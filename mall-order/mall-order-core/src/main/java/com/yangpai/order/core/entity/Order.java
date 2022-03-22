package com.yangpai.order.core.entity;

import com.yangpai.conmon.baseclass.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 订单基类
 * @author kuangyoupeng1
 * @date 2022.02.10
 */
@Setter
@Getter
@ToString
public class Order extends BaseEntity {

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 商品id 目前仅支持单个下单
     */
    private Long skuId;

    /**
     * 订单金额
     */
    private BigDecimal amount;

    /**
     * 支付状态
     */
    private int payStatus;

    /**
     * 订单状态
     */
    private int status;

    /**
     * 买家id
     */
    private Long receiverId;

    /**
     * 买家姓名
     */
    private String receiverName;

    /**
     * 买家收货地址
     */
    private String receiverAddress;

    /**
     * 买家手机号
     */
    private String receiverPhone;

    /**
     * 卖家id
     */
    private Long sellerId;

    /**
     * 卖家姓名
     */
    private String sellerName;

    /**
     * 卖家发货地址
     */
    private String sellerAddress;

    /**
     * 卖家手机号
     */
    private String sellerPhone;

    /**
     * 备注
     */
    private String comment;
}
