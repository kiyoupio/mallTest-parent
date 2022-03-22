package com.yangpai.commodity.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangpai.commodity.server.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;

/**
 * 商品mapper
 * @author kuangyoupeng1
 * @date 2022.02.13
 */
@Mapper
public interface CommodityMapper extends BaseMapper<Commodity> {
    /**
     * 根据id查询商品详情
     * @param id
     * @return
     */
    Commodity selectCommodityInfoById(Long id);
}
