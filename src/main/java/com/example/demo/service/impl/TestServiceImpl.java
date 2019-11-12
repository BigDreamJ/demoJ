package com.example.demo.service.impl;

import com.example.demo.entity.Test;
import com.example.demo.mapper.TestMapper;
import com.example.demo.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试表 服务实现类
 * </p>
 *
 * @author BigJ
 * @since 2019-07-02
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

}
