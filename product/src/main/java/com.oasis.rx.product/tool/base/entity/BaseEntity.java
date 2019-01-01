package com.oasis.rx.product.tool.base.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.Instant;
import lombok.Data;

/**
 * 公共实体类，封装了每个实体的公共字段-包括:id,operator,isDelete,remark,createTime,updateTime
 *
 * @author 郭贤达
 */
@Data
public abstract class BaseEntity implements Serializable {

  protected BaseEntity() {
  }

  public BaseEntity(String id) {
    this.id = id;
  }

  /**
   * 主键Id
   */
  @ApiModelProperty("主键id")
  protected String id;

  /**
   * 操作人
   */
  @ApiModelProperty("操作人")
  private String operatorId;

  /**
   * 删除标记
   */
  @ApiModelProperty(value = "是否删除 0-否,1-是")
  private int deleted;

  /**
   * 备注
   */
  @ApiModelProperty("备注")
  private String remark;
  /**
   * 创建日期
   */
  @ApiModelProperty("创建日期")
  //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Instant createTime;

  /**
   * 更新日期
   */
  @ApiModelProperty("更新日期")
  //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Instant updateTime;

}
