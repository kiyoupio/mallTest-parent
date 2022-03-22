package com.yangpai.commodity.server.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yangpai.commodity.server.entity.Commodity;
import com.yangpai.commodity.server.service.CommodityService;
import com.yangpai.conmon.component.ApiResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 普通商品控制器
 * @author kuangyoupeng1
 * @date 2022.02.13
 */
@RestController
public class CommodityController {
    /**
     * 普通商品服务类
     */
    @Resource(name = "commodityService")
    private CommodityService commodityService;

    /**
     * 普通商品列表
     * @return
     */
    @GetMapping("commodity/normal/sku/page")
    public ApiResult<IPage<Commodity>> skuList(@RequestParam Integer pageNum){
        // 默认一页10个数据
        return ApiResult.success(commodityService.getCommodityList(pageNum));
    }

    /**
     * 商品详情
     * @param skuId
     * @return
     */
    @GetMapping("commodity/info/{skuId}")
    public ApiResult<Commodity> getCommodityInfo(@PathVariable("skuId") Long skuId){
        return ApiResult.success(commodityService.getById(skuId));
    }

    /**
     * 发布商品
     * @return
     */
    @PostMapping("commodity/create")
    public ApiResult createCommodity(@RequestBody Commodity commodity){
        return ApiResult.success(commodityService.saveCommodity(commodity));
    }


    /**
     * 删除商品
     * @return
     */
    @DeleteMapping("commodity/del")
    public ApiResult delCommodity(@RequestParam List<Long> skuIds){
        return ApiResult.success(commodityService.delCommodity(skuIds));
    }
}
