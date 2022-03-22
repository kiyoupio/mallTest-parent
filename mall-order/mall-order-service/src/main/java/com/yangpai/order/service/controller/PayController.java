package com.yangpai.order.service.controller;

import com.yangpai.conmon.component.ApiResult;
import com.yangpai.order.core.pay.PayDto;
import com.yangpai.order.service.service.impl.PayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * ali pay控制器
 * @author kuangyoupeng1
 * @date 2022.3.18
 */
@RestController
public class PayController {
    /**
     * ali-pay service
     */
    @Resource
    private PayService payService;

    @PostMapping("/order/ali-pay")
    public ApiResult webSitePay(@RequestBody PayDto payDto) {
        return ApiResult.success(payService.webSitePay(payDto));
    }

    /**
     * 支付宝支付回调
     *
     * @param request 回调信息
     * @return
     */
    @PostMapping("/order/notify")
    public String paySuccess(HttpServletRequest request) {
        return payService.payNotify(request);
    }
}
