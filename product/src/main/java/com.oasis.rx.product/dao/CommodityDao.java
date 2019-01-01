package com.oasis.rx.product.dao;

import com.oasis.rx.product.entity.CommodityEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by 郭贤达 on 2017-12-05 11:14:54.
 */
@Repository
public interface CommodityDao {
  /**
   * 添加
   * @param commodityEntity 商品
   * @return 数值
   */
  int create(CommodityEntity commodityEntity);

  /**
   * 删除商品
   * @param id 商品id
   * @return 数值
   */
  int deleted(String id);

  /**
   * 修改商品
   * @param commodityEntity 商品
   * @return 数值
   */
  int update(CommodityEntity commodityEntity);

  /**
   * 查询商品
   * @param id 商品id
   * @return 商品记录
   */
  CommodityEntity get(String id);

  /**
   * 判断是否已存在
   * @param id 商品id
   * @return 布尔值
   */
  boolean existed(String id);
}
