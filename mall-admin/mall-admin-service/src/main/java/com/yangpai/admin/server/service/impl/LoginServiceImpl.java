package com.yangpai.admin.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yangpai.admin.core.dto.LoginRequestDTO;
import com.yangpai.admin.core.entity.AdminRole;
import com.yangpai.admin.core.entity.AdminUser;
import com.yangpai.admin.server.constant.AdminConstants;
import com.yangpai.admin.server.service.AdminUserService;
import com.yangpai.admin.server.service.LoginService;
import com.yangpai.admin.server.utils.EncodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 用户登录服务实现类
 * @author kuangyoupeng1
 * @date 2022.1.24
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    /**
     * redis服务
     */
    @Resource
    private RedisService redisService;

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
     * http请求头
     */
    @Resource
    private HttpHeaders httpHeaders;

    /**
     * 配置文件中Oauth2 resource配置
     */
    @Resource
    private OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails;

    @Override
    public ResponseEntity<OAuth2AccessToken> login(LoginRequestDTO loginRequestDTO) {
        // 避免多次重复登录
        if (redisService.existKey("user:" + loginRequestDTO.getUsername())){
            return new ResponseEntity("请不要重复登录",HttpStatus.BAD_REQUEST);
        }
        long start = System.currentTimeMillis();
        AdminUser user = adminUserService.getOne(new LambdaQueryWrapper<AdminUser>()
                .select(AdminUser::getId, AdminUser::getUserName, AdminUser::getPassword)
                .eq(AdminUser::getUserName, loginRequestDTO.getUsername()));
        List<AdminRole> adminRoles = adminUserService.getRolesByUserId(user.getId());
        List<String> roles = new ArrayList<>();
        for (AdminRole adminRole : adminRoles) {
            roles.add(adminRole.getName());
        }
        user.setRolesName(roles);
        log.info("{}:登录获取user:{}", this.getClass().getSimpleName(), user);
        long midd = System.currentTimeMillis();
        log.info("第一条查询语句的耗时[{}]ms", midd - start);
        if (!EncodeUtil.matches(loginRequestDTO.getPassword(), user.getPassword())){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        log.info("密码匹配耗时[{}]ms", System.currentTimeMillis() - midd);
        redisService.setCacheObject("user:" + loginRequestDTO.getUsername(), user, 30, TimeUnit.MINUTES);
        // 请求参数
        // map-链表：一个key多个value
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>(4);
        map.put(AdminConstants.USERNAME_KEY, Collections.singletonList(loginRequestDTO.getUsername()));
        map.put(AdminConstants.PASSWORD_KEY, Collections.singletonList(loginRequestDTO.getPassword()));
        map.put(AdminConstants.GRANT_TYPE_KEY, Collections.singletonList(oAuth2ProtectedResourceDetails.getGrantType()));
        map.put(AdminConstants.SCOPE_KEY, oAuth2ProtectedResourceDetails.getScope());
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, httpHeaders);
        long mid = System.currentTimeMillis();
        // 请求到授权服务器，将授权完的用户信息存到授权服务器，并申请令牌
        ResponseEntity<OAuth2AccessToken> responseEntity = restTemplate.exchange(oAuth2ProtectedResourceDetails.getAccessTokenUri(), HttpMethod.POST,
                httpEntity, OAuth2AccessToken.class);
        long end = System.currentTimeMillis();
        log.info("第一阶段耗费[{}]ms,第二阶段耗费[{}]ms", mid - start, end -mid);
        return responseEntity;
    }
}