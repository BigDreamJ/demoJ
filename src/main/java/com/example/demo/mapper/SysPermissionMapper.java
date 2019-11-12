package com.example.demo.mapper;

import com.example.demo.entity.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author BigJ
 * @since 2019-07-03
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    List<SysPermission> findByAdminUserId(int userId);
}
