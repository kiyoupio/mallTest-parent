package com.yangpai.order.core.constants;

/**
 * 支付相关常量
 * @author kuangyoupeng1
 * @date 2022.3.21
 */
public interface PayConstants {
    /**
     * 支付成功返回
     */
    String SUCCESS = "success";

    /**
     * 支付失败返回
     */
    String FAIL = "fail";

    /**
     * 订单号
     */
    String ORDER_ID = "order_id";

    /**
     * skuId
     */
    String SKU_ID = "sku_id";

    /**
     * 下单人id
     */
    String PAYER_ID = "payer_id";
}
