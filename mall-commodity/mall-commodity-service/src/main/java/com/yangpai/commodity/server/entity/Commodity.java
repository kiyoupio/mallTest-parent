package com.yangpai.commodity.server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.yangpai.conmon.baseclass.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


/**
 * 商品sku实体
 * @author kuangyoupeng1
 * @date 2022.02.11
 */
@Setter
@Getter
@ToString
public class Commodity extends BaseEntity {
    /**
     * 发布人Id
     */
    private Long userId;

    /**
     * 商品价格
     */
    private Double price;

    /**
     * 商品名称
     */
    private String skuName;

    /**
     * 首页图片
     */
    private String homePic;

    /**
     * 商品详细图片file path
     */
    @TableField(exist = false)
    private List<String> skuPicList;

    /**
     * 描述
     */
    private String comment;

    /**
     * 库存
     */
    private int count;

    /**
     * 商品状态
     */
    private int status;

    /**
     * 商品类型 1:正常商品 2:回收商品
     */
    private int skuType;
}
