package com.yangpai.commodity.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangpai.commodity.server.entity.Category;
import com.yangpai.commodity.server.mapper.CategoryMapper;
import com.yangpai.commodity.server.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品分类服务实现类
 * @author kuangyoupeng1
 * @date 2022.4.10
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Override
    public List<Category> getCategoryList() {
        List<Category> allCategory = super.list(new LambdaQueryWrapper<Category>()
                .select(Category::getId, Category::getParentId, Category::getCategoryName));
        if (allCategory.isEmpty()){
            return null;
        }
        // 取出一级分类列表
        List<Category> rootMenu = allCategory.stream().filter(menu -> menu.getParentId().equals(0L)).collect(Collectors.toList());
        rootMenu.forEach(category-> category.setChildList(findChild(category.getId(), allCategory)));
        return rootMenu;
    }

    @Override
    public List<Category> getTopCategoryList() {
        List<Category> topCategory = super.list(new LambdaQueryWrapper<Category>()
                .select(Category::getId, Category::getCategoryName).
                        eq(Category::getParentId, 0));
        return topCategory;
    }

    @Override
    public List<Category> getChildCategoryList(Long id) {
        List<Category> childCategory = super.list(new LambdaQueryWrapper<Category>()
                .select(Category::getId, Category::getCategoryName).
                        eq(Category::getParentId, id));
        return childCategory;
    }

    /**
     * 插入子菜单
     * @param id
     * @param categories
     * @return
     */
    private List<Category> findChild(Long id, List<Category> categories) {
        List<Category> childCategory = categories.stream().filter(menu -> menu.getParentId().equals(id)).collect(Collectors.toList());
        // 递归出全部子菜单
        childCategory.forEach(category -> category.setChildList(findChild(category.getId(), categories)));
        return childCategory;
    }
}
