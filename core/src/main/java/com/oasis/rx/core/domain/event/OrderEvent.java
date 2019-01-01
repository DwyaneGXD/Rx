package com.oasis.rx.core.domain.event;

import com.oasis.rx.core.domain.entity.OrderEntity;
import com.oasis.rx.core.domain.vo.OrderVO;
import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Option;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单领域事件
 */
public interface OrderEvent
{
  /**
   * 创建订单
   */
  @AllArgsConstructor
  final class Created implements OrderEvent
  {
    public final String                        id;
    public final OrderVO.OrderDoctor           doctor;
    public final OrderVO.OrderUser             user;
    public final Option<String>                diagnosis;
    public final String                        cartId;
    public final List<OrderVO.OrderProduct>    products;
    public final List<OrderVO.OrderProduct>    customs;
    public final List<OrderEntity.OrderDetail> details;
    public final BigDecimal                    itemsMoney;
    public final List<OrderVO.OrderProposal>   proposals;
    public final Option<String>                comment;
    public final String                        source;
    public final String                        thirdId;
    public final Date                          createTime;
    public final Date                          updateTime;
  }

  /**
   * 修改订单
   */
  @AllArgsConstructor
  final class Updated implements OrderEvent
  {
    public final String                        id;
    public final Option<String>                diagnosis;
    public final List<OrderVO.OrderProduct>    products;
    public final List<OrderVO.OrderProduct>    customs;
    public final List<OrderEntity.OrderDetail> details;
    public final BigDecimal                    itemsMoney;
    public final List<OrderVO.OrderProposal>   proposals;
    public final String                        source;
    public final Option<String>                comment;
    public final String                        thirdId;
    public final Date                          updateTime;
  }

  /**
   * 审核已通过
   */
  @AllArgsConstructor
  final class ReviewPassed implements OrderEvent
  {
    public final String id;
    public final String thirdId;
    public final Date   reviewTime;
  }

  /**
   * 审核被拒绝
   */
  @AllArgsConstructor
  final class ReviewRejected implements OrderEvent
  {
    public final String              id;
    public final String              thirdId;
    public final OrderVO.OrderReview review;
    public final Date                reviewTime;
  }

  /**
   * 再次提交审核
   */
  @AllArgsConstructor
  final class ReviewContinued implements OrderEvent
  {
    public final String id;
    public final String thirdId;
    public final Date   reviewTime;
  }

  /**
   * 付款
   */
  @AllArgsConstructor
  final class Paid implements OrderEvent
  {
    public final String                       id;
    public final String                       thirdId;
    public final Integer                      wayCode;
    public final BigDecimal                   actualMoney;
    public final OrderVO.OrderDelivery        delivery;
    public final Seq<OrderEntity.OrderDetail> details;
    public final Seq<OrderVO.OrderItem>       items;
    public final String                       source;
    public final Date                         updateTime;
  }

  /**
   * 取消
   */
  @AllArgsConstructor
  final class Canceled implements OrderEvent
  {
    public final String id;
    public final String thirdId;
    public final Date   updateTime;
  }

  /**
   * 确认收货
   */
  @AllArgsConstructor
  final class Confirmed implements OrderEvent
  {
    public final String id;
    public final String thirdId;
    public final Date   updateTime;
  }

  /**
   * 去收银台
   */
  @AllArgsConstructor
  final class GoneCashier implements OrderEvent
  {
    public final String     id;
    public final String     thirdId;
    public final String     deliveryWay;
    public final BigDecimal deliveryMoney;
    public final String     consignee;
    public final String     mobile;
    public final String     address;
    public final Date       updateTime;
  }

  /**
   * 发货
   */
  @AllArgsConstructor
  final class Delivered implements OrderEvent
  {
    public final String id;
    public final String thirdId;
    public final String deliveryName;
    public final String deliveryCode;
    public final String deliveryNo;
    public final Date   updateTime;
  }

  /**
   * 批量订单(按来源拆单)
   */
  @AllArgsConstructor
  final class CreatedBatch implements OrderEvent
  {
    public final String                  id;
    public final OrderVO.OrderUser       user;
    public final BigDecimal              itemsMoney;
    public final Option<String>          comment;
    public final String                  source;
    public final String                  deliveryWay;
    public final BigDecimal              deliveryMoney;
    public final String                  consignee;
    public final String                  mobile;
    public final String                  address;
    public final List<OrderVO.OrderItem> items;
    public final String                  cartId;
    public final Date                    createTime;
    public final Date                    updateTime;
  }

  /**
   * 提醒发货
   */
  @AllArgsConstructor
  final class Notified implements OrderEvent
  {
    public final String id;
    public final Date   updateTime;
  }

  /**
   * 删除
   */
  @AllArgsConstructor
  final class Deleted implements OrderEvent
  {
    public final String id;
    public final Date   updateTime;
  }
}
