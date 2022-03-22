package com.yangpai.commodity.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangpai.commodity.server.entity.Commodity;
import com.yangpai.commodity.server.constant.CommodityConstant;
import com.yangpai.commodity.server.entity.CommodityPic;
import com.yangpai.commodity.server.enums.CommodityStatusEnum;
import com.yangpai.commodity.server.enums.CommodityTypeEnum;
import com.yangpai.commodity.server.mapper.CommodityMapper;
import com.yangpai.commodity.server.service.CommodityPicService;
import com.yangpai.commodity.server.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 回收商品服务实现类
 * @author kuangyoupeng1
 * @date 2022.02.13
 */
@Service("recycleCommodityService")
public class RecycleCommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements CommodityService {
    /**
     * 商品图片服务
     */
    @Resource
    private CommodityPicService commodityPicService;

    @Override
    public IPage<Commodity> getCommodityList(Integer pageNum) {
        return baseMapper.selectPage(new Page<>(pageNum, CommodityConstant.PAGE_SIZE),
                new LambdaQueryWrapper<Commodity>().eq(Commodity::getSkuType, CommodityTypeEnum.RECYCLE.getType()));
    }

    @Override
    public boolean takeDownCommodity(Long skuId) {
        return super.update(new LambdaUpdateWrapper<Commodity>().eq(Commodity::getId, skuId)
                .set(Commodity::getStatus, CommodityStatusEnum.TAKE_DOWN.getStatus()));
    }

    @Override
    public boolean saveCommodity(Commodity commodity) {
        List<String> picPathList = commodity.getSkuPicList();
        List<CommodityPic> commodityPicList = new ArrayList<>();
        for (String picPath : picPathList) {
            CommodityPic commodityPic = new CommodityPic();
            commodityPic.setCommodityId(commodity.getId());
            commodityPic.setPicPath(picPath);
            commodityPicList.add(commodityPic);
        }
        commodityPicService.saveBatch(commodityPicList);
        return super.save(commodity);
    }

    @Override
    public boolean delCommodity(List<Long> skuIds) {
        commodityPicService.remove(new LambdaQueryWrapper<CommodityPic>().in(CommodityPic::getCommodityId, skuIds));
        baseMapper.deleteBatchIds(skuIds);
        return true;
    }
}
