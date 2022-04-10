package com.yangpai.commodity.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangpai.commodity.server.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * category mapper
 * @author kuangyoupeng1
 * @date 2022.4.10
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
