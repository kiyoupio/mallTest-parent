package com.yangpai.order.core.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 回收订单实体
 * @author kuangyoupeng1
 * @date
 */
@Setter
@Getter
@ToString
public class RecycleOrder extends Order{

    /**
     * 序列化id
     */
    private static final long serialVersionUID = 1L;

    /**
     * 回收类型
     */
    private Long recycleType;

    /**
     * 回收公斤
     */
    private int weight;

    /**
     * 预约回收时间
     */
    private Date recycleTime;
}
