package com.yangpai.admin.core.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 创建用户请求实体
 *
 * @author kuangyoupeng1
 * @date 2022.02.09
 */
@Setter
@Getter
@ToString
public class CreateRequestDTO {
    /**
     * 电子邮件
     */
    private String email;

    /**
     * 邮箱验证码
     */
    private String code;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话
     */
    private String tel;

    /**
     * 学校名称
     */
    private String school;
}
