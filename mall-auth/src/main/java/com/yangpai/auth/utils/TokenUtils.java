package com.yangpai.auth.utils;

import com.yangpai.auth.constant.AuthConstant;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.io.IOException;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

/**
 * token工具类
 * @author kuangyoupeng1
 * @date 2022.1.24
 */
public class TokenUtils {

    /**
     * 获取token
     * @return
     */
    public static String adminToken() throws IOException {
        // 证书路径
        ClassPathResource classPathResource = new ClassPathResource(AuthConstant.KEY_LOCATION);
        // 密钥工厂
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(classPathResource, AuthConstant.KEY_PASSWORD.toCharArray());
        // 密钥对
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(AuthConstant.KEY_PASSWORD, AuthConstant.KEY_PASSWORD.toCharArray());
        // 私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        // 定义token的payload
        Map<String, Object> payload = new HashMap<>();
        payload.put(AuthConstant.USER_NAME_KEY, AuthConstant.USER_NAME_VALUE);
        payload.put(AuthConstant.CLIENT_ID_KEY, AuthConstant.CLIENT_ID_VALUE);
        // "authorities":["ROLE_ADMIN"]
        payload.put(AuthConstant.AUTHORITIES_KEY, new String[]{AuthConstant.AUTHORITIES_VALUE_ROLE_ADMIN});
        // 生成jwt令牌
        Jwt jwt = JwtHelper.encode(new ObjectMapper().writeValueAsString(payload), new RsaSigner(privateKey));
        // 取出jwt令牌
        return jwt.getEncoded();
    }
}
