package com.oasis.rx.core.domain.event;

import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Date;

/**
 * 用户领域事件
 */
public interface UserEvent
{
  /**
   * 后台创建
   */
  @AllArgsConstructor
  final class Created implements UserEvent
  {
    public final String       id;
    public final String       nickname;
    public final String       email;
    public final String       mobile;
    public final String       username;
    public final String       password;
    public final List<String> roles;
    public final boolean      enable;
    public final String       source;
    public final Date         createTime;
    public final Date         updateTime;
  }

  /**
   * 用户注册
   */
  @AllArgsConstructor
  final class Registered implements UserEvent
  {
    @TargetAggregateIdentifier
    public final String id;
    public final String oasisId;
    public final Date   createTime;
    public final Date   updateTime;
  }

  /**
   * 修改
   */
  @AllArgsConstructor
  final class Updated implements UserEvent
  {
    public final String       id;
    public final String       nickname;
    public final String       email;
    public final String       mobile;
    public final String       password;
    public final List<String> roles;
    public final Boolean      enable;
    public final String       source;
    public final Date         updateTime;
  }

  /**
   * 创建地址
   */
  @AllArgsConstructor
  final class CreatedAddress implements UserEvent
  {
    public final String          id;
    public final String          userId;
    public final String          consignee;
    public final String          mobile;
    public final String          province;
    public final String          city;
    public final String          district;
    public final Option<Integer> zipCode;
    public final String          street;
    public final Integer         typeCode;
    public final Boolean         isDefault;
    public final Date            createTime;
    public final Date            updateTime;
  }

  /**
   * 修改地址
   */
  @AllArgsConstructor
  final class UpdatedAddress implements UserEvent
  {
    public final String          id;
    public final String          userId;
    public final String          consignee;
    public final String          mobile;
    public final String          province;
    public final String          city;
    public final String          district;
    public final Option<Integer> zipCode;
    public final String          street;
    public final Integer         typeCode;
    public final Boolean         isDefault;
    public final Date            updateTime;
  }

  /**
   * 删除地址
   */
  @AllArgsConstructor
  final class DeletedAddress implements UserEvent
  {
    public final String id;
    public final String userId;
    public final Date   updateTime;
  }

  /**
   * 设置默认地址
   */
  @AllArgsConstructor
  final class ConfiguredDefaultAddress implements UserEvent
  {
    public final String id;
    public final String userId;
    public final Date   updateTime;
  }
}
