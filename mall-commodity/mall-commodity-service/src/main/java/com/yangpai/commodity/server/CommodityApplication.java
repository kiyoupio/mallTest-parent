package com.yangpai.commodity.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 商品服务启动类
 * @author kuangyoupeng1
 * @date 2022.3.7
 */
@SpringBootApplication
@EnableFeignClients
public class CommodityApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommodityApplication.class, args);
    }
}
