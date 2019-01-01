package com.oasis.rx.product.service.impl;

import com.oasis.rx.core.tool.ObjectId;
import com.oasis.rx.product.dao.CommodityDao;
import com.oasis.rx.product.entity.CommodityEntity;
import com.oasis.rx.product.param.CommodityParam;
import com.oasis.rx.product.service.CommodityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class CommodityServiceImpl implements CommodityService {
  private final CommodityDao commodityDao;

  @Override
  public int create(CommodityParam param) {
    CommodityEntity commodityEntity = new CommodityEntity();

    commodityEntity.setId(ObjectId.get().toString());
    commodityEntity.setName(param.getName());
    commodityEntity.setPrice(param.getPrice());
    commodityEntity.setQuantity(param.getQuantity());

    return this.commodityDao.create(commodityEntity);
  }

  @Override
  public int deleted(String id) {
    return this.commodityDao.deleted(id);
  }

  @Override
  public int update(CommodityParam param) {
    CommodityEntity commodityEntity = new CommodityEntity();

    commodityEntity.setName(param.getName());
    commodityEntity.setPrice(param.getPrice());
    commodityEntity.setQuantity(param.getQuantity());

    return this.commodityDao.update(commodityEntity);
  }

  @Override
  public CommodityEntity get(String id) {
    return this.commodityDao.get(id);
  }
}
