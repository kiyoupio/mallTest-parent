package com.yangpai.order.service.config;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import com.yangpai.order.service.properties.AliPayProperties;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 支付宝配置类
 * @author kuangyoupeng1
 * @date 2022.3.21
 */
@Configuration
@EnableConfigurationProperties({AliPayProperties.class})
public class AliPayConfig implements ApplicationRunner {
    /**
     * 支付宝相关配置
     */
    @Resource
    private AliPayProperties aliPayProperties;
    /**
     * 应用启动最后自动执行 yyds
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Config config = new Config();
        config.protocol = aliPayProperties.getProtocol();
        config.gatewayHost = aliPayProperties.getGatewayHost();
        config.signType = aliPayProperties.getSignType();
        config.appId = aliPayProperties.getAppId();
        config.merchantPrivateKey = aliPayProperties.getPrivateKey();
        config.alipayPublicKey = aliPayProperties.getPublicKey();
        config.notifyUrl = aliPayProperties.getNotifyUrl();
        config.encryptKey = aliPayProperties.getEncryptKey();
        Factory.setOptions(config);
    }
}
