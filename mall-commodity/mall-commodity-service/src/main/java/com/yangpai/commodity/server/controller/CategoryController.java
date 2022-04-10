package com.yangpai.commodity.server.controller;

import com.yangpai.commodity.server.entity.Category;
import com.yangpai.commodity.server.service.CategoryService;
import com.yangpai.conmon.component.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类控制器
 * @author kuangyoupeng1
 * @date 2022.4.10
 */
@RestController
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    /**
     * 获取商品分类列表
     * @return
     */
    @GetMapping("/commodity/category/list")
    public ApiResult<List<Category>> getCategoryList(){
        return ApiResult.success(categoryService.getCategoryList());
    }

    /**
     * 获取父列表
     * @return
     */
    @GetMapping("/commodity/category/topList")
    public ApiResult<List<Category>> getTopCategoryList(){
        return ApiResult.success(categoryService.getTopCategoryList());
    }

    /**
     * 获取子列表
     * @return
     */
    @GetMapping("/commodity/category/topList/{id}")
    public ApiResult<List<Category>> getChildCategoryList(@PathVariable("id") Long id){
        return ApiResult.success(categoryService.getChildCategoryList(id));
    }
}
