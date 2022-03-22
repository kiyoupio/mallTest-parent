package com.yangpai.commodity.server.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 商品图片存储配置
 * @author kuangyoupeng1
 * @date 2022.3.15
 */
@Configuration
public class MinioConfig {
    /**
     * 服务url
     */
    @Value("${spring.minio.endpoint}")
    private String endpoint;

    /**
     * 访问账号
     */
    @Value("${spring.minio.accessKey}")
    private String accessKey;

    /**
     * 访问密码
     */
    @Value("${spring.minio.secretKey}")
    private String secretKey;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }
}
