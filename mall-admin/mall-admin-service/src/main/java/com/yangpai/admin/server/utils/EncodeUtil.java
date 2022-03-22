package com.yangpai.admin.server.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * BC加密工具类
 * @author kuangyoupeng1
 * @date 2022.1.24
 */
public class EncodeUtil {
    /**
     * BC加密
     */
    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    /**
     * 密码匹配
     * @param password
     * @param encodedPassword
     * @return
     */
    public static boolean matches(String password, String encodedPassword){
        return PASSWORD_ENCODER.matches(password, encodedPassword);
    }
}
