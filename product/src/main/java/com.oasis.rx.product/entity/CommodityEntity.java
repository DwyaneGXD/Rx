package com.oasis.rx.product.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.Instant;
import lombok.Data;

/**
 * Created by 郭贤达 on 2017-12-05 11:14:54.
 */
@Data
@ApiModel("药品产品")
public class CommodityEntity {
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
  //商品名称
  @ApiModelProperty(value = "商品名称", required = true)
  private String name;
  //售价
  @ApiModelProperty(value = "售价", required = true)
  private BigDecimal price;
  //数量
  @ApiModelProperty(value = "数量")
  private Integer quantity;
}
