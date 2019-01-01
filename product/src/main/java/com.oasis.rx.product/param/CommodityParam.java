package com.oasis.rx.product.param;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CommodityParam {
  @ApiModelProperty(value = "主键id", required = true)
  private String id;
  /**
   * 商品名称
   */
  @ApiModelProperty(value = "商品名称", required = true)
  private String name;
  /**
   * 售价
   */
  @ApiModelProperty(value = "售价", required = true)
  private BigDecimal price;
  /**
   * 数量
   */
  @ApiModelProperty(value = "数量")
  private Integer quantity;
  /**
   * 操作人id
   */
  @ApiModelProperty(value = "操作人id")
  private Integer operatorId;
}
