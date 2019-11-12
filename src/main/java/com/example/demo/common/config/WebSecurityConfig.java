package com.example.demo.common.config;

import com.example.demo.common.security.MyFilterSecurityInterceptor;
import com.example.demo.common.security.MyPasswordEncoder;
import com.example.demo.service.impl.SysUserServiceImpl;
import com.example.demo.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Slf4j
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    @Bean
    UserDetailsService customUserService(){//注册UserDetailsService 的bean
        return new SysUserServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(customUserService());//user Details Service验证
        //可以设置内存指定的登录的账号密码,指定角色
        //不加.passwordEncoder(new MyPasswordEncoder())
        //就不是以明文的方式进行匹配，会报错
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        //.passwordEncoder(new MyPasswordEncoder())。
        //这样，页面提交时候，密码以明文的方式进行匹配。
//        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("cxh").password("cxh").roles("ADMIN");
        auth.userDetailsService(customUserService()).passwordEncoder(new PasswordEncoder(){

            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String)rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                log.info(MD5Util.encode((String)rawPassword) + "=================== " + encodedPassword);
                return encodedPassword.equals(MD5Util.encode((String)rawPassword));
            }}); //user Details Service验证

        auth
                .inMemoryAuthentication()
                .withUser("wyf").password("wyf").roles("USER")
                .and()
                .withUser("wisely").password("wisely").roles("USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //设置静态资源不要拦截
        web.ignoring().antMatchers("/js/**","/css/**","/images/**");
        web.ignoring().antMatchers("/resources/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.authorizeRequests()每个匹配器按照它们被声明的顺序被考虑。
        http
                .authorizeRequests()
                // 所有用户均可访问的资源
                .antMatchers("/css/**", "/js/**", "/images/**", "/webjars/**", "**/favicon.ico").permitAll()
                // ROLE_USER的权限才能访问的资源
                .antMatchers("/user/**").hasRole("USER")
                // 任何尚未匹配的URL只需要验证用户即可访问
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // 指定登录页面,授予所有用户访问登录页面
                .loginPage("/login")
                //设置默认登录成功跳转页面,错误回到login界面
                .defaultSuccessUrl("/index").failureUrl("/login?error").permitAll()
                .and()
                //开启cookie保存用户数据
                .rememberMe()
                //设置cookie有效期
                .tokenValiditySeconds(60 * 60 * 24 * 7)
                //设置cookie的私钥
                .key("security")
                .and()
                .logout()
                .permitAll();
        //登录拦截器
        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class)
                //springsecurity4自动开启csrf(跨站请求伪造)与restful冲突
                .csrf().disable();
    }


}
