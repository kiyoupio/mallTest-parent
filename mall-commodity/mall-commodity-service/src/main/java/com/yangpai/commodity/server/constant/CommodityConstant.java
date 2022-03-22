package com.yangpai.commodity.server.constant;

/**
 * 商品相关常量类
 * @author kuangyoupeng1
 * @date 2022.3.7
 */
public interface CommodityConstant {

    /**
     * 商品返回默认每页10个数据
     */
    Integer PAGE_SIZE = 10;

    /**
     * 图片路径前缀 要和配置文件的minio bucket一致
     */
    String PIC_PREFIX = "yangpai.cool:9000/commodity";
}
