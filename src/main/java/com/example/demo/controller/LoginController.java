package com.example.demo.controller;

import com.example.demo.common.Message;
import com.example.demo.entity.SysUser;
import com.example.demo.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping("/index")
    public String index(Model model){
        SysUser sysUser = sysUserService.getById(1);
        Message msg =  new Message("测试标题","测试内容","额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }
    @RequestMapping("/admin")
    @ResponseBody
    public String hello(){
        return "hello admin";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/user")
    @ResponseBody
    public String getList(){
        return "hello getList";
    }


    @PostMapping("user")
    @ResponseBody
    public String save(){
        return "hello save";
    }


    @PutMapping("/user")
    @ResponseBody
    public String update(){
        return "hello update";
    }

}
