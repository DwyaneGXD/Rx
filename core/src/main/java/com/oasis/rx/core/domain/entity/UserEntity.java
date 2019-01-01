package com.oasis.rx.core.domain.entity;

import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * 用户领域实体
 */
public interface UserEntity
{
  /**
   * 用户地址
   */
  @Data
  @AllArgsConstructor
  class UserAddress implements UserEntity
  {
    private String          id;
    private String          consignee;
    private String          mobile;
    private String          province;
    private String          city;
    private String          district;
    private Option<Integer> zipCode;
    private String          street;
    private Integer         typeCode;
    private Boolean         isDefault;
    private Date            createTime;
    private Date            updateTime;
  }
}
