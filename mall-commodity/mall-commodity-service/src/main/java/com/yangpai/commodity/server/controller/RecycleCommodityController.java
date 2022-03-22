package com.yangpai.commodity.server.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yangpai.commodity.server.entity.Commodity;
import com.yangpai.commodity.server.service.CommodityPicService;
import com.yangpai.commodity.server.service.CommodityService;
import com.yangpai.conmon.component.ApiResult;
import com.yangpai.conmon.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 回收换取商品控制器
 * @author kuangyoupeng1
 * @date 2022.02.13
 */
@Slf4j
@RestController
public class RecycleCommodityController {
    /**
     * 回收商品服务
     */
    @Resource(name = "recycleCommodityService")
    private CommodityService commodityService;

    /**
     * 商品图片服务
     */
    @Resource(name = "commodityPicService")
    private CommodityPicService commodityPicService;

    /**
     * 旧物回收可换商品列表
     * @return
     */
    @GetMapping("commodity/recycle/sku/page")
    public ApiResult<IPage<Commodity>> recycleSkuList(@RequestParam Integer pageNum){
        // 默认一页10个数据
        return ApiResult.success(commodityService.getCommodityList(pageNum));
    }

    /**
     * TODO 对所有商品id可以做一个redis bitmap来过滤垃圾消息
     * @param skuId
     * @return
     */
    @GetMapping("commodity/recycle/sku_info/{skuId}")
    public ApiResult<Commodity> recycleSkuInfo(@PathVariable Long skuId){
        List<String> picPathList = commodityPicService.getPicListByCommodityId(skuId);
        // 可以加一个计数，超过多少加入缓存
        Commodity commodity = commodityService.getById(skuId);
        commodity.setSkuPicList(picPathList);
        return ApiResult.success(commodity);
    }

    /**
     * 新增回收商品
     * 管理员权限
     * @return
     */
    @PostMapping("commodity/recycle/create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ApiResult createRecycleCommodity(@RequestBody Commodity commodity){
        return ApiResult.success(commodityService.save(commodity));
    }

    /**
     * 下架回收商品
     * 管理员权限
     * @param skuId
     * @return
     */
    @GetMapping("commodity/recycle/take_down/{skuId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ApiResult takeDownRecycleCommodity(@PathVariable Long skuId){
        return ApiResult.success(commodityService.takeDownCommodity(skuId));
    }

    /**
     * 删除回收商品
     * 管理员权限
     * @return
     */
    @DeleteMapping("commodity/recycle/del/{skuId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ApiResult delCommodity(@PathVariable Long skuId){
        return ApiResult.success(commodityService.removeById(skuId));
    }
}
