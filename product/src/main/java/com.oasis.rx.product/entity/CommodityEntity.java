package com.oasis.rx.product.entity;

import com.oasis.rx.product.tool.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.Data;

/**
 * Created by 郭贤达 on 2017-12-05 11:14:54.
 */
@Data
@ApiModel("药品产品")
public class CommodityEntity extends BaseEntity {
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
