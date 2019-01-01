package com.oasis.rx.core.domain.event;

import com.oasis.rx.core.domain.entity.CartEntity;
import io.vavr.collection.List;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 购物车领域事件
 */
public interface CartEvent
{
  /**
   * 创建购物车
   */
  @AllArgsConstructor
  final class Created implements CartEvent
  {
    public final String  id;
    public final String  userId;
    public final Integer typeCode;
    public final Date    createTime;
    public final Date    updateTime;
  }

  /**
   * 添加购物车产品
   */
  @AllArgsConstructor
  final class AddedProduct implements CartEvent
  {
    public final String                 id;
    public final Integer                productTypeCode;
    public final CartEntity.CartProduct product;
    public final Date                   updateTime;
  }

  /**
   * 修改购物车产品
   */
  @AllArgsConstructor
  final class UpdatedProduct implements CartEvent
  {
    public final String                 id;
    public final Integer                productTypeCode;
    public final CartEntity.CartProduct product;
    public final Date                   updateTime;
  }

  /**
   * 删除购物车产品
   */
  @AllArgsConstructor
  final class RemovedProduct implements CartEvent
  {
    public final String                 id;
    public final CartEntity.CartProduct product;
    public final Integer                cartProductTypeCode;
    public final Date                   updateTime;
  }

  /**
   * 创建购物车物品
   */
  @AllArgsConstructor
  final class CreatedItem implements CartEvent
  {
    public final String              id;
    public final CartEntity.CartItem item;
    public final Date                updateTime;
  }

  /**
   * 修改购物车物品
   */
  @AllArgsConstructor
  final class UpdatedItem implements CartEvent
  {
    public final String  id;
    public final String  cartItemId;
    public final Integer amount;
    public final Date    updateTime;
  }

  /**
   * 删除购物车物品
   */
  @AllArgsConstructor
  @ToString
  final class RemovedItems implements CartEvent
  {
    public final String       id;
    public final List<String> cartItemIds;
    public final Date         updateTime;
  }
}
