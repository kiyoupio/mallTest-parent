package com.yangpai.admin.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.FileCopyUtils;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 创建TokenStore配置使用公钥验证令牌
 * @author kuangyoupeng1
 * @date 2022.1.25
 */
@Configuration
public class JwtConfig {

    private static final String PUBLIC_KEY = "public.key";

    @Resource
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Bean
    public TokenStore tokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    @Bean
    protected JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        ClassPathResource resource = new ClassPathResource(PUBLIC_KEY);
        String publicKey;
        try {
            publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException();
        }

        // 设置校验公钥
        converter.setVerifierKey(publicKey);
        // 设置证书签名密码
        converter.setSigningKey("yangpai");

        return converter;
    }
}
