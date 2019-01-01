package com.oasis.rx.product.service;

import com.oasis.rx.product.entity.CommodityEntity;
import com.oasis.rx.product.param.CommodityParam;

/**
 * 商品
 * 
 * @author Dwyane Guo
 * date    2018/12/28
 */
public interface CommodityService {
  /**
   * 添加
   * @param commodityParam 商品
   * @return 数值
   */
  int create(CommodityParam commodityParam);

  /**
   * 删除商品
   * @param id 商品id
   * @return 数值
   */
  int deleted(String id);

  /**
   * 修改商品
   * @param commodityParam 商品
   * @return 数值
   */
  int update(CommodityParam commodityParam);

  /**
   * 查询商品
   * @param id 商品id
   * @return 商品记录
   */
  CommodityEntity get(String id);
}
