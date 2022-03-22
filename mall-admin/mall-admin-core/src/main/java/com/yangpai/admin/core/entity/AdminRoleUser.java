package com.yangpai.admin.core.entity;

import com.yangpai.conmon.baseclass.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 角色用户关联实体
 * @author kuangyoupeng1
 * @date 2022.02.09
 */
@Setter
@Getter
@ToString
public class AdminRoleUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 用户ID
     */
    private Long userId;
}
