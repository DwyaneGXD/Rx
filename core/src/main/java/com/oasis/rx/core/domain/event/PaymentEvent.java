package com.oasis.rx.core.domain.event;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付领域事件
 */
public interface PaymentEvent
{
  /**
   * 付款
   */
  @AllArgsConstructor
  final class Paid implements PaymentEvent
  {
    public final String     id;
    public final String     orderId;
    public final BigDecimal money;
    public final Integer    wayCode;
    public final Date       beginTime;
    public final Date       createTime;
    public final Date       updateTime;
  }

  /**
   * 付款成功
   */
  @AllArgsConstructor
  final class PaidSuccess implements PaymentEvent
  {
    public final String     id;
    public final String     orderId;
    public final String     thirdId;
    public final BigDecimal money;
    public final Integer    wayCode;
    public final Date       updateTime;
  }

  /**
   * 付款完成
   */
  @AllArgsConstructor
  final class PaidFinish implements PaymentEvent
  {
    public final String     id;
    public final String     orderId;
    public final String     thirdId;
    public final BigDecimal money;
    public final Integer    wayCode;
    public final Date       updateTime;
  }

  /**
   * 付款关闭
   */
  @AllArgsConstructor
  final class PaidClosed implements PaymentEvent
  {
    public final String  id;
    public final String  orderId;
    public final String  thirdId;
    public final Integer wayCode;
    public final Date    updateTime;
  }
}
