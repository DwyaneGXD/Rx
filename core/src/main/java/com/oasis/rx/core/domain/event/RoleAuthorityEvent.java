package com.oasis.rx.core.domain.event;

import lombok.AllArgsConstructor;

import java.util.Date;

/**
 * 角色权限领域事件
 */
public interface RoleAuthorityEvent
{
  /**
   * 创建
   */
  @AllArgsConstructor
  final class Created implements RoleAuthorityEvent
  {
    public final String  id;
    public final String  name;
    public final String  value;
    public final boolean enable;
    public final Date    createTime;
    public final Date    updateTime;
  }

  /**
   * 修改
   */
  @AllArgsConstructor
  final class Updated implements RoleAuthorityEvent
  {
    public final String  id;
    public final String  name;
    public final String  value;
    public final boolean enable;
    public final Date    updateTime;
  }

  /**
   * 删除
   */
  @AllArgsConstructor
  final class Deleted implements RoleAuthorityEvent
  {
    public final String id;
    public final Date   updateTime;
  }
}
