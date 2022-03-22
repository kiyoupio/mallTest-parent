package com.yangpai.admin.server.controller;

import com.yangpai.admin.core.dto.LoginRequestDTO;
import com.yangpai.admin.server.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户登录控制器
 * @author kuangyoupeng1
 * @date 2022
 */
@RestController
@Slf4j
public class LoginController {

    /**
     * 登录服务
     */
    @Resource
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseEntity<OAuth2AccessToken> login(@RequestBody LoginRequestDTO loginRequestDTO){
        log.info("{}:登录请求:{}", this.getClass().getSimpleName(), loginRequestDTO);
        return loginService.login(loginRequestDTO);
    }
}
