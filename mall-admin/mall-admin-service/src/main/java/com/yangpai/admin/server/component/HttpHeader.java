package com.yangpai.admin.server.component;

import com.yangpai.admin.server.constant.AdminConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Base64;

/**
 * HTTP请求头
 * @author kuangyoupeng1
 */
@Component
public class HttpHeader {
    /**
     * 配置文件中客户端配置
     */
    @Resource
    private OAuth2ClientProperties oAuth2ClientProperties;

    @Bean
    public HttpHeaders httpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.set(AdminConstants.AUTHORIZATION_KEY, StringUtils.join(AdminConstants.BASIC_KEY, Base64.getEncoder().encodeToString(
                StringUtils.join(Arrays.asList(oAuth2ClientProperties.getClientId(), oAuth2ClientProperties.getClientSecret()),
                        AdminConstants.SPLIT).getBytes())));
        return headers;
    }
}
