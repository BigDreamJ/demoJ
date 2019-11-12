package com.example.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.common.BaseController;

/**
 * <p>
 * 测试表 前端控制器
 * </p>
 *
 * @author BigJ
 * @since 2019-07-02
 */
@Api(tags = "1.0", value = "测试接口", description = "这是一个测试接口")
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {


    @ApiOperation("测试接口")
    @GetMapping("/test")
    public String test(){
        return "测试成功";
    }

}
