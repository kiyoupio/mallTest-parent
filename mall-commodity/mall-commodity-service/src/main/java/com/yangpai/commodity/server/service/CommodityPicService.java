package com.yangpai.commodity.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangpai.commodity.server.entity.CommodityPic;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品图片服务类
 * @author kuangyoupeng1
 * @date 2022.3.16
 */
@Service
public interface CommodityPicService extends IService<CommodityPic> {
    /**
     * 通过商品id获取图片列表
     * @param id
     * @return
     */
    List<String> getPicListByCommodityId(Long id);
}
