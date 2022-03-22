package com.yangpai.commodity.server.entity;

import com.yangpai.conmon.baseclass.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 商品图片实体类
 * @author kuangyoupeng1
 * @date 2022.3.16
 */
@Setter
@Getter
@ToString
public class CommodityPic extends BaseEntity {
    /**
     * 图片路径
     */
    private String picPath;

    /**
     * 商品id
     */
    private Long commodityId;
}
