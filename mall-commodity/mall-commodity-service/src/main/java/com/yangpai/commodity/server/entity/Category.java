package com.yangpai.commodity.server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.yangpai.conmon.baseclass.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 商品类别表
 * @author kuangyoupeng1
 * @date 2022.4.10
 */
@Getter
@Setter
public class Category extends BaseEntity {

    /**
     * 父分类id
     */
    private Long parentId;

    /**
     * 分类名
     */
    private String categoryName;

    /**
     * 子分类
     */
    @TableField(exist = false)
    private List<Category> childList;
}
