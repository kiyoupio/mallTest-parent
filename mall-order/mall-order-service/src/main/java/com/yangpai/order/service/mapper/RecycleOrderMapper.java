package com.yangpai.order.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangpai.order.core.entity.RecycleOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * 回收订单mapper
 * @author kuangyoupeng1
 * @date 2022.3.18
 */
@Mapper
public interface RecycleOrderMapper extends BaseMapper<RecycleOrder> {
}
