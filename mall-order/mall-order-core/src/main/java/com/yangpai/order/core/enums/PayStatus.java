package com.yangpai.order.core.enums;

import lombok.Getter;

/**
 * 订单支付状态枚举类
 * @author kuangyoupeng1
 * @date 2022.2.28
 */
@Getter
public enum PayStatus {
    /**
     * 未支付
     */
    UNPAID(0L, "未支付"),

    /**
     * 已支付
     */
    PAID(1L, "已支付");

    /**
     * 状态
     */
    private Long status;

    /**
     * 描述
     */
    private String desc;

    /**
     * 构造enum
     * @param status
     * @param desc
     */
    PayStatus(Long status, String desc){
        this.status = status;
        this.desc = desc;
    }
}
