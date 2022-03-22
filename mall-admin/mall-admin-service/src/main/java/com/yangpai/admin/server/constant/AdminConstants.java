package com.yangpai.admin.server.constant;

/**
 * @author kuangyoupeng1
 * @date 2022.1.24
 */
public interface AdminConstants {
    /**
     * 请求头key
     */
    String AUTHORIZATION_KEY = "Authorization";

    /**
     * Basic
     */
    String BASIC_KEY = "Basic ";

    /**
     * 用户名key
     */
    String USERNAME_KEY = "username";

    /**
     * 密码key
     */
    String PASSWORD_KEY = "password";

    /**
     * 认证类型key
     */
    String GRANT_TYPE_KEY = "grant_type";

    /**
     * 授权范围key
     */
    String SCOPE_KEY = "scope";

    /**
     * 分隔符
     */
    String SPLIT = ":";

    /**
     * 注册验证码前缀
     */
    String REGISTER_CODE_PREFIX = "register";

    /**
     * 重置验证码前缀
     */
    String RESET_CODE_PREFIX = "reset";
}