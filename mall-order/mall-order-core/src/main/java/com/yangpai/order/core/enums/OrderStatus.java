package com.yangpai.order.core.enums;

/**
 * 订单状态枚举
 * @author kuangyoupeng1
 * @date 2022.3.18
 */
public enum OrderStatus {
    /**
     * 等待回收
     */
    UN_RECYCLE(0L, "等待回收"),

    /**
     * 已回收
     */
    RECYCLE(1L, "已回收"),

    /**
     * 待发货
     */
    UN_SHIP(2L, "待发货"),

    /**
     * 待收货
     */
    SHIPPING(3L, "待收货"),

    /**
     * 已送达
     */
    SHIPPED(4L, "已送达"),

    /**
     * 确认收货
     */
    DELIVERED(5L, "确认收货");

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
    OrderStatus(Long status, String desc){
        this.status = status;
        this.desc = desc;
    }
}
