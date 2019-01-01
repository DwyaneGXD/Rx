package com.oasis.rx.core.domain.entity;

import io.vavr.collection.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 购物车领域实体
 */
public interface CartEntity
{
  /**
   * 购物车产品
   */
  @Builder
  @AllArgsConstructor
  final class CartProduct implements CartEntity
  {
    public final String       id;
    public final String       productId;
    public final String       name;
    public final String       standard;
    public final String       produceFactory;
    public final List<String> sources;
    public final String       usage;
    public final String       frequency;
    public final String       dosage;
    public final Integer      amount;
    public final Integer      day;
    public final Date         createTime;
    public final Date         updateTime;
  }

  /**
   * 购物车物品
   */
  @Data
  @AllArgsConstructor
  final class CartItem implements CartEntity
  {
    private String     id;
    private String     itemId;
    private String     name;
    private String     icon;
    private Integer    amount;
    private String     source;
    private BigDecimal price;
    private Date       createTime;
    private Date       updateTime;
  }
}
