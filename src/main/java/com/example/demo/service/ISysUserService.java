package com.example.demo.service;

import com.example.demo.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author BigJ
 * @since 2019-07-03
 */
public interface ISysUserService extends IService<SysUser> {

    UserDetails loadUserByUsername(String username);
}
