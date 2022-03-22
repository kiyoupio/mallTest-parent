package com.yangpai.conmon.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 安全认证工具
 * @author kuangyoupeng1
 * @date 2022.3.9
 */
public class SecurityUtils {

    /**
     * 获取当前认证信息
     * @return
     */
    public static Authentication getCurrentUser(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取当前用户名
     * @return
     */
    public static String getUsername(){
        return getCurrentUser().getPrincipal().toString();
    }
}
