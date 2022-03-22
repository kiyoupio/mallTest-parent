package com.yangpai.order.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangpai.order.core.entity.RecycleOrder;
import com.yangpai.order.service.mapper.RecycleOrderMapper;
import com.yangpai.order.service.service.RecycleOrderService;
import org.springframework.stereotype.Service;

/**
 * 回收订单服务实现类
 * @author kuangyoupeng1
 * @date 2022.3.18
 */
@Service("recycleOrderService")
public class RecycleOrderServiceImpl extends ServiceImpl<RecycleOrderMapper, RecycleOrder> implements RecycleOrderService {
}
