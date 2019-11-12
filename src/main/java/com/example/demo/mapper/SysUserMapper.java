package com.example.demo.mapper;

import com.example.demo.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author BigJ
 * @since 2019-07-03
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser findByUserName(@Param("username") String username);
}
