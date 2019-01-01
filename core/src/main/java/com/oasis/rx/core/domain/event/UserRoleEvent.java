package com.oasis.rx.core.domain.event;

import io.vavr.collection.List;
import lombok.AllArgsConstructor;

import java.util.Date;

/**
 * 用户角色领域事件
 */
public interface UserRoleEvent
{
  /**
   * 创建
   */
  @AllArgsConstructor
  final class Created implements UserRoleEvent
  {
    public final String       id;
    public final String       name;
    public final String       value;
    public final List<String> authorities;
    public final String       parentId;
    public final boolean      enable;
    public final Date         createTime;
    public final Date         updateTime;
  }

  /**
   * 修改
   */
  @AllArgsConstructor
  final class Updated implements UserRoleEvent
  {

    public final String       id;
    public final String       name;
    public final String       value;
    public final List<String> authorities;
    public final String       parentId;
    public final boolean      enable;
    public final Date         updateTime;
  }
}
