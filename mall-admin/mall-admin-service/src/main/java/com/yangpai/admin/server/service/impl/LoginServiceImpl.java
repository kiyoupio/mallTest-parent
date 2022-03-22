package com.yangpai.admin.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yangpai.admin.core.dto.LoginRequestDTO;
import com.yangpai.admin.core.entity.AdminUser;
import com.yangpai.admin.server.constant.AdminConstants;
import com.yangpai.admin.server.service.AdminUserService;
import com.yangpai.admin.server.service.LoginService;
import com.yangpai.admin.server.utils.EncodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.http.*;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;

/**
 * 用户登录服务实现类
 * @author kuangyoupeng1
 * @date 2022.1.24
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    /**
     * http调用
     */
    @Resource
    private RestTemplate restTemplate;

    /**
     * 用户服务
     */
    @Resource
    private AdminUserService adminUserService;

    /**
     * 配置文件中客户端配置
     */
    @Resource
    private OAuth2ClientProperties oAuth2ClientProperties;

    /**
     * 配置文件中Oauth2 resource配置
     */
    @Resource
    private OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails;

    @Override
    public ResponseEntity<OAuth2AccessToken> login(LoginRequestDTO loginRequestDTO) {
        AdminUser user = adminUserService.getOne(new LambdaQueryWrapper<AdminUser>()
                .eq(AdminUser::getUserName, loginRequestDTO.getUsername()));
        log.info("{}:登录获取user:{}", this.getClass().getSimpleName(), user.toString());
        if (!EncodeUtil.matches(loginRequestDTO.getPassword(), user.getPassword())){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        // 客户端认证信息
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(AdminConstants.AUTHORIZATION_KEY, StringUtils.join(AdminConstants.BASIC_KEY, Base64.getEncoder().encodeToString(
                StringUtils.join(Arrays.asList(oAuth2ClientProperties.getClientId(), oAuth2ClientProperties.getClientSecret()),
                        AdminConstants.SPLIT).getBytes())
        ));
        // 请求参数
        // map-链表：一个key多个value
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>(4);
        map.put(AdminConstants.USERNAME_KEY, Collections.singletonList(loginRequestDTO.getUsername()));
        map.put(AdminConstants.PASSWORD_KEY, Collections.singletonList(loginRequestDTO.getPassword()));
        map.put(AdminConstants.GRANT_TYPE_KEY, Collections.singletonList(oAuth2ProtectedResourceDetails.getGrantType()));
        map.put(AdminConstants.SCOPE_KEY, oAuth2ProtectedResourceDetails.getScope());
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, httpHeaders);
        // 请求到授权服务器，将授权完的用户信息存到授权服务器，并申请令牌
        return restTemplate.exchange(oAuth2ProtectedResourceDetails.getAccessTokenUri(), HttpMethod.POST,
                httpEntity, OAuth2AccessToken.class);
    }
}