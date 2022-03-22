package com.yangpai.admin.core.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.yangpai.conmon.baseclass.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 用户信息实体
 * @author kuangyoupeng1
 * @date 2022.1.21
 */
@Setter
@Getter
@ToString
public class AdminUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 描述
     */
    private String comment;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 是否锁定
     */
    private Boolean accountLock;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实名称
     */
    private String realName;

    /**
     * 加密密码的盐
     */
    private String salt;

    /**
     * 性别
     */
    private String sex;

    /**
     * 电话
     */
    private String tel;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 学校名称
     */
    private String school;

    /**
     * 瞬时属性，用户的角色列表，如：[1,3,4,5]
     */
    @TableField(exist = false)
    private Long[] roleIds;
}
