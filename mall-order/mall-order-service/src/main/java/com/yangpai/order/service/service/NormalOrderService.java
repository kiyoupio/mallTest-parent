package com.yangpai.order.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yangpai.order.core.entity.NormalOrder;

/**
 * 普通订单服务接口
 * @author kuangyoupeng1
 * @date 2022.3.18
 */
public interface NormalOrderService extends IService<NormalOrder> {
    /**
     * 获取普通订单(拼接sku部分信息)分页列表
     * @param pageNum
     * @param orderStatus
     * @return
     */
    public IPage<NormalOrder> getNormalOrderList(Integer pageNum, Integer orderStatus);
}
