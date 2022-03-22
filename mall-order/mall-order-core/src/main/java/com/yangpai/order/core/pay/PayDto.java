package com.yangpai.order.core.pay;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 支付数据Dto
 * @author kuangyoupeng1
 * @date 2022.3.21
 */
@Getter
@Setter
@ToString
public class PayDto implements Serializable {
    /**
     * 序列化id
     */
    private static final long serialVersionUID = 1L;

    /**
     * 订单名称
     */
    private String subject;

    /**
     * 商品描述
     */
    private String body;

    /**
     * 总金额(单位是分)
     */
    private String amount;

    /**
     * 订单号(唯一)
     */
    private String orderId;
}
