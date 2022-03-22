package com.yangpai.admin.server.service;

import com.yangpai.admin.core.dto.LoginRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;

/**
 * 登录服务接口
 * @author kuangyoupeng1
 * @date 2022.1.24
 */
@Service
public interface LoginService {
    /**
     * 用户登录
     *
     * @param loginRequestDTO 登录请求DTO
     * @return org.springframework.http.ResponseEntity
     */
    ResponseEntity<OAuth2AccessToken> login(LoginRequestDTO loginRequestDTO);
}
