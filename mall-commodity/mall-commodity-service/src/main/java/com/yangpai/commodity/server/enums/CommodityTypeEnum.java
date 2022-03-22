package com.yangpai.commodity.server.enums;

import lombok.Getter;

/**
 * 商品类型枚举类
 * @author kuangyoupeng
 * @date 2022.3.6
 */
@Getter
public enum CommodityTypeEnum {
    /**
     * 普通商品
     */
    NORMAL(1, "普通商品"),
    /**
     * 回收商品
     */
    RECYCLE(2, "回收商品");

    /**
     * 商品类型
     */
    private final int type;

    /**
     * 类型描述
     */
    private final String desc;

    /**
     * 构造enum
     * @param type
     * @param desc
     */
    CommodityTypeEnum(int type, String desc){
        this.type = type;
        this.desc = desc;
    }
}
