package com.yangpai.commodity.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangpai.commodity.server.constant.CommodityConstant;
import com.yangpai.commodity.server.entity.CommodityPic;
import com.yangpai.commodity.server.mapper.CommodityPicMapper;
import com.yangpai.commodity.server.service.CommodityPicService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品图片服务实现类
 * @author kuangyoupeng1
 * @date 2022.3.16
 */
@Service("commodityPicService")
public class CommodityPicServiceImpl extends ServiceImpl<CommodityPicMapper, CommodityPic> implements CommodityPicService{

    @Override
    public List<String> getPicListByCommodityId(Long id) {
        List<String> picPathList = new ArrayList<>();
        List<CommodityPic> commodityPicList = super.list(new LambdaQueryWrapper<CommodityPic>().select(CommodityPic::getPicPath).eq(CommodityPic::getCommodityId, id));
        if (commodityPicList != null && !commodityPicList.isEmpty()){
            for (CommodityPic commodityPic : commodityPicList) {
                if (commodityPic != null){
                    picPathList.add(CommodityConstant.PIC_PREFIX + commodityPic.getPicPath());
                }
            }
        }
        // 未查询到会返回空
        return picPathList;
    }
}
