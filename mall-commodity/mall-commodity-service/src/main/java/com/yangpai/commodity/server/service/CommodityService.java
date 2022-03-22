package com.yangpai.commodity.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yangpai.commodity.server.entity.Commodity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品Service
 * @author kuangyoupeng1
 * @date 2022.02.13
 */
@Service
public interface CommodityService extends IService<Commodity> {
    /**
     * 分页查询商品列表
     * @param pageNum 页码
     * @return
     */
    IPage<Commodity> getCommodityList(Integer pageNum);

    /**
     * 下架某商品
     * @param skuId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    boolean takeDownCommodity(Long skuId);

    /**
     * 保存商品
     * @param commodity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    boolean saveCommodity(Commodity commodity);

    /**
     * 批量删除
     * @param skuIds
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    boolean delCommodity(List<Long> skuIds);
}
