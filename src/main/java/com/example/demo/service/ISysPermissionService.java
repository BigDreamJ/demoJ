package com.example.demo.service;

import com.example.demo.entity.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author BigJ
 * @since 2019-07-03
 */
public interface ISysPermissionService extends IService<SysPermission> {

    List<SysPermission> findByAdminUserId(int userId);
}
