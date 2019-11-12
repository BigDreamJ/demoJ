package com.example.demo.service.impl;

import com.example.demo.entity.SysPermission;
import com.example.demo.mapper.SysPermissionMapper;
import com.example.demo.service.ISysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author BigJ
 * @since 2019-07-03
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {

    @Override
    public List<SysPermission> findByAdminUserId(int userId){
        return baseMapper.findByAdminUserId(userId);
    }
}
