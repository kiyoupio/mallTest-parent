package com.yangpai.order.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangpai.order.core.entity.NormalOrder;
import com.yangpai.order.service.mapper.NormalOrderMapper;
import com.yangpai.order.service.service.NormalOrderService;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

/**
 * 普通订单服务实现类
 * @author kuangyoupeng1
 * @date 2022.3.18
 */
@Service("normalOrderService")
public class NormalOrderServiceImpl extends ServiceImpl<NormalOrderMapper, NormalOrder> implements NormalOrderService {
    /**
     * 全状态查询
     */
    private final static Integer ALL_ORDER_STATUS = -1;
    @Override
    public IPage<NormalOrder> getNormalOrderList(Integer pageNum, Integer orderStatus) {
        return null;
    }
}
