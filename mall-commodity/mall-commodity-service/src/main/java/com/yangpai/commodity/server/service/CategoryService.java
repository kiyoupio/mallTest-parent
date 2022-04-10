package com.yangpai.commodity.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangpai.commodity.server.entity.Category;

import java.util.List;

/**
 * 商品分类service
 * @author kuangyoupeng1
 * @date 2022.4.10
 */
public interface CategoryService extends IService<Category> {

    /**
     * 获取所有商品分类列表
     * @return
     */
    List<Category> getCategoryList();

    /**
     * 获取Top商品分类
     * @return
     */
    List<Category> getTopCategoryList();

    /**
     * 获取某个分类的子分类
     * @return
     */
    List<Category> getChildCategoryList(Long id);
}
