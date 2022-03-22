package com.yangpai.auth.constant;

/**
 * 安全认证常量
 * @author kuangyoupeng1
 * @date 2022.1.21
 */
public class AuthConstant {
    /**
     * 秘钥全名称
     */
    public static final String KEY_LOCATION = "yangpai.jks";

    /**
     * 密钥的密码，此密码和别名要匹配
     */
    public static final String KEY_PASSWORD = "yangpai";

    /**
     * 用户名key
     */
    public static final String USER_NAME_KEY = "user_name";

    /**
     * 管理员key
     */
    public static final String USER_NAME_VALUE = "admin";

    /**
     * 客户端Id
     */
    public static final String CLIENT_ID_KEY = "client_id";

    /**
     * client
     */
    public static final String CLIENT_ID_VALUE = "com/client";

    /**
     * authorities
     */
    public static final String AUTHORITIES_KEY = "authorities";

    /**
     * ROLE_ADMIN
     */
    public static final String AUTHORITIES_VALUE_ROLE_ADMIN = "ROLE_ADMIN";

    /**
     * Authorization
     */
    public static final String AUTHORIZATION_KEY = "Authorization";

    /**
     * bearer_key
     */
    public static final String BEARER_KEY = "Bearer ";
}