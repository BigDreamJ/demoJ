package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.demo.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author BigJ
 * @since 2019-07-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "用户表")
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @TableField(exist = false, select = false)
    @ApiModelProperty(value = "角色")
    private List<String> roles;


}
