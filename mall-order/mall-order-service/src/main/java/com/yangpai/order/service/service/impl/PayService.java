package com.yangpai.order.service.service.impl;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import com.yangpai.order.core.constants.PayConstants;
import com.yangpai.order.core.pay.PayDto;
import com.yangpai.order.service.properties.AliPayProperties;
import com.yangpai.order.service.service.NormalOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * ali pay 服务类
 * @author kuangyoupeng1
 * @date 2022.3.18
 */
@Service("payService")
@Slf4j
public class PayService {
    /**
     * 普通订单服务
     */
    @Resource(name = "normalOrderService")
    private NormalOrderService normalOrderService;

    /**
     * 支付宝相关配置
     */
    @Resource
    private AliPayProperties aliPayProperties;

    /**
     * 网页支付
     * @param payDto
     * @return
     */
    public String webSitePay(PayDto payDto){
        // 自定义参数用于回调
        // TODO 订单超时支付
        Map<String, Object> callbackParams = new HashMap<>(16);
        AlipayTradePagePayResponse alipayTradePagePayResponse = null;
        // 向支付宝发起下单请求
        try{
            alipayTradePagePayResponse = Factory.Payment.Page().pay(payDto.getSubject(), payDto.getOrderId(),
                    payDto.getAmount(), aliPayProperties.getReturnUrl());
        } catch (Exception e) {
            log.error("订单支付异常", e);
            return PayConstants.FAIL;
        }
        if (ResponseChecker.success(alipayTradePagePayResponse)) {
            return alipayTradePagePayResponse.getBody();
        } else {
            log.error("支付宝电脑网站支付失败");
            return PayConstants.FAIL;
        }
    }

    /**
     * ali pay支付回调
     * @param httpServletRequest
     * @return
     */
    public String payNotify(HttpServletRequest httpServletRequest){
        log.info("----获取回执-----:{}", httpServletRequest.toString());
        return null;
    }
}
