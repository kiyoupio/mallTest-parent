package com.yangpai.order.service.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 支付宝相关配置
 *
 * @author kuangyoupeng1
 * @date 2022.3.21
 */
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "ali.pay")
public class AliPayProperties {
    /**
     * appId
     */
    private String appId;

    /**
     * 应用私钥
     */
    private String privateKey;

    /**
     * 支付宝公钥
     */
    private String publicKey;

    /**
     * 回调地址
     */
    private String notifyUrl;

    /**
     * 支付成功跳转页
     */
    private String returnUrl;

    /**
     * 订单相对超时时间
     */
    private String timeoutExpress;

    /**
     * 协议
     */
    private String protocol;

    /**
     * 支付宝网关
     */
    private String gatewayHost;

    /**
     * 签名类型
     */
    private String signType;

    /**
     * 加密key
     */
    public String encryptKey;
}
