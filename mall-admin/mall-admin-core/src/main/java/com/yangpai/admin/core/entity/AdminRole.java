package com.yangpai.admin.core.entity;

import com.yangpai.conmon.baseclass.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 角色对象实体
 *
 * @author kuangyoupeng1
 * @date 2022.1.25
 */
@Setter
@Getter
@ToString
public class AdminRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 描述
     */
    private String comment;

    /**
     * 名称
     */
    private String name;

    /**
     * 标题
     */
    private String title;


}