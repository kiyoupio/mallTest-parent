package com.yangpai.auth.utils;

import com.yangpai.auth.constant.AuthConstant;
import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

class TokenUtilsTest {

    @org.junit.jupiter.api.Test
    void adminToken() throws IOException {
//        // 证书路径
//        ClassPathResource classPathResource = new ClassPathResource(AuthConstant.KEY_LOCATION);
//        // 密钥工厂
//        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(classPathResource, AuthConstant.KEY_PASSWORD.toCharArray());
//        // 密钥对
//        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(AuthConstant.KEY_PASSWORD, AuthConstant.KEY_PASSWORD.toCharArray());
//        // 私钥
//        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
//        //定义payload信息
//        Map<String, Object> tokenMap = new HashMap<String, Object>();
//        tokenMap.put("id", "123");
//        tokenMap.put("name", "malong");
//        tokenMap.put("roles", "r01,r02");
//        tokenMap.put("ext", "1");
//        // 生成jwt
//        Jwt jwt = JwtHelper.encode(new ObjectMapper().writeValueAsString(tokenMap), new RsaSigner(privateKey));
//        String token = jwt.getEncoded();
//        System.out.println(token);


//        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHQiOiIxIiwicm9sZXMiOiJyMDEscjAyIiwibmFtZSI6Im1hbG9uZyIsImlkIjoiMTIzIn0.SzJXTzPgknM0BJlSAXN-pM3oMQ8CE3_cA4abDFPvagooQp-VLsxhYhH6NwEwoqDQ20fiE8iy7G05-jeBruCHLgWVlYZq14MdNkd0vxYEZk1uZ78dMoMH1k2F185zY_MPgitcSGKaj_Y7Op6zs3A72mlms9Hi9WvCt_l65essfVo";
//        String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
//                "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCf/udCWjVWD1GIlzVZA/AvPR9v\n" +
//                "9PV+PfWakfYYciajIWY8CNZeL13421AAl/3OU/brJAav1Qj03Gt9bIaxOhwpo+pl\n" +
//                "oPId5yXMMOh+IoMgOVyG2kAYMBdZM3v6W/bQDfggITGfEkWGSMuCTSt0qChYx0lH\n" +
//                "1Ay76vgmFmZLnbctzwIDAQAB\n" +
//                "-----END PUBLIC KEY-----\n";
//        // 校验jwt
//        Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(publicKey));
//        // 获取原始内容
//        String claims = jwt.getClaims();
//
//        try {
//            Map map = new ObjectMapper().readValue(claims, Map.class);
//            System.out.println(map);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String s = bCryptPasswordEncoder.encode("000000");
        System.out.println(s);
    }
}