package com.yangpai.admin.core.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户登录请求实体
 * @author kuangyoupeng1
 * @date 2022.1.24
 */
@Setter
@Getter
@ToString
public class LoginRequestDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}