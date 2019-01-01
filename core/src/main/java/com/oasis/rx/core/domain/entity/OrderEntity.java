package com.oasis.rx.core.domain.entity;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单领域实体
 */
public interface OrderEntity
{
  /**
   * 订单详情实体
   */
  @AllArgsConstructor
  final class OrderDetail implements OrderEntity
  {
    public final String     id;
    //商品ID
    public final String     itemId;
    //名
    public final String     name;
    //规格
    public final String     standard;
    //厂家
    public final String     produceFactory;
    //用法
    public final String     usage;
    //频次
    public final String     frequency;
    //剂量
    public final String     dosage;
    //数量
    public final Integer    amount;
    //天数
    public final Integer    day;
    //单价
    public final BigDecimal price;
    //应收金额
    public final BigDecimal chargeMoney;
    //第三方ID
    public final String     goodsId;
    public final Date       createTime;
  }
}
