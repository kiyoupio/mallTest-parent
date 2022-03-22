package com.yangpai.order.service.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yangpai.conmon.component.ApiResult;
import com.yangpai.order.core.entity.NormalOrder;
import com.yangpai.order.service.service.NormalOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 普通商品订单控制器
 * @author kuangyoupeng1
 * @date 2022.2.28
 */
@RestController
public class NormalOrderController {
    /**
     * 普通订单服务类
     */
    private NormalOrderService normalOrderService;

    /**
     * 普通订单列表
     * @return
     */
    @GetMapping("/order/normal/list")
    public ApiResult<IPage<NormalOrder>> normalOrderList(@RequestParam Integer pageNum, @RequestParam Integer orderStatus){
        // 默认一页10个数据
        return ApiResult.success(normalOrderService.getNormalOrderList(pageNum, orderStatus));
    }
}
