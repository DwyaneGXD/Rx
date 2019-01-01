package com.oasis.rx.core.domain.vo;

import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单领域值对象
 */
public interface OrderVO
{
  /**
   * 订单医生
   */
  @AllArgsConstructor
  final class OrderDoctor implements OrderVO
  {
    public final String         id;
    public final String         name;
    public final Option<String> signId;
    public final Option<String> signName;
    public final Option<Date>   signTime;
  }

  /**
   * 订单价格
   */
  @AllArgsConstructor
  final class OrderPrice implements OrderVO
  {
    //商品金额
    public final BigDecimal itemsMoney;
    //物流金额
    public final BigDecimal deliveryMoney;
    //总计金额
    public final BigDecimal totalMoney;
    //应收
    public final BigDecimal chargeMoney;
    //实收
    public final BigDecimal actualMoney;
  }

  /**
   * 订单产品
   */
  @Builder
  @AllArgsConstructor
  final class OrderProduct implements OrderVO
  {
    public final String       id;
    public final String       name;
    public final String       standard;
    public final String       produceFactory;
    public final List<String> sources;
    public final String       usage;
    public final String       frequency;
    public final String       dosage;
    public final Integer      amount;
    public final Integer      day;
    public final String       goodsId;
  }

  /**
   * 订单审核
   */
  @AllArgsConstructor
  final class OrderReview implements OrderVO
  {
    public final String content;
    public final Date   reviewTime;
  }

  /**
   * 订单用户
   */
  @AllArgsConstructor
  final class OrderUser implements OrderVO
  {
    public final String  id;
    public final String  name;
    public final Integer sexCode;
    public final Integer age;
    public final String  mobile;
  }

  /**
   * 订单建议服务
   */
  @AllArgsConstructor
  final class OrderProposal implements OrderVO
  {
    public final String  id;
    public final String  name;
    public final Integer typeCode;
    public final String  icon;
    public final String  comment;
  }

  /**
   * 订单支付信息
   */
  @AllArgsConstructor
  final class OrderPayment implements OrderVO
  {
    public final Integer wayCode;
    public final Integer payStatusCode;
    public final Date    payTime;
  }

  /**
   * 订单物流信息
   */
  @Builder
  @AllArgsConstructor
  final class OrderDelivery implements OrderVO
  {
    public final String deliveryWay;
    public final String address;
    public final String consignee;
    public final String mobile;
    public final String code;
    public final String name;
    public final String no;
    public final Date   createTime;
  }

  /**
   * 订单物品
   */
  @AllArgsConstructor
  final class OrderItem implements OrderVO
  {
    public final String               id;
    public final String               name;
    public final BigDecimal           price;
    public final Integer              amount;
    public final String               icon;
    public final String               description;
    public final List<OrderCommodity> commodities;
  }

  /**
   * 订单商品
   */
  @AllArgsConstructor
  final class OrderCommodity implements OrderVO
  {
    public final String     id;
    public final String     name;
    public final Integer    quantity;
    public final String     goodsId;
    public final BigDecimal price;
    public final String     source;
  }
}
