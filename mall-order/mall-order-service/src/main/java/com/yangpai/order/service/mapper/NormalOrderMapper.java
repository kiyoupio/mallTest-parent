package com.yangpai.order.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangpai.order.core.entity.NormalOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * 正常订单mapper
 * @author kuangyoupeng1
 * @date 2022.3.18
 */
@Mapper
public interface NormalOrderMapper extends BaseMapper<NormalOrder> {
}
