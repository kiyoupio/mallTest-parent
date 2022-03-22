package com.yangpai.commodity.server.enums;

import lombok.Getter;

/**
 * 商品状态枚举类
 * @author kuangyoupeng
 * @date 2022.3.6
 */
@Getter
public enum CommodityStatusEnum {
    /**
     * 正常在售
     */
    SALE(1, "在售"),
    /**
     * 售罄
     */
    SELLOUT(2, "售罄"),
    /**
     * 下架
     */
    TAKE_DOWN(3, "下架");

    /**
     * 商品状态
     */
    private final int status;

    /**
     * 状态描述
     */
    private final String desc;

    /**
     * 构造enum
     * @param status
     * @param desc
     */
    CommodityStatusEnum(int status, String desc){
        this.status = status;
        this.desc = desc;
    }
}
