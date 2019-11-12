package com.example.demo.entity;

import com.example.demo.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 测试表
 * </p>
 *
 * @author BigJ
 * @since 2019-07-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Test extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 名字
     */
    private String name;


}
