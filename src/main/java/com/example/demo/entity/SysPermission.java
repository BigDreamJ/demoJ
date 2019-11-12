package com.example.demo.entity;

import com.example.demo.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author BigJ
 * @since 2019-07-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "权限表")
public class SysPermission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "权限描述")
    private String description;

    @ApiModelProperty(value = "授权链接")
    private String url;

    @ApiModelProperty(value = "父节点id")
    private Integer pid;

    @ApiModelProperty(value = "请求方式")
    private String method;


}
