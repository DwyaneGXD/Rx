package com.oasis.rx.product.api.controller;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static java.util.Objects.nonNull;

import com.oasis.rx.core.tool.Restful;
import com.oasis.rx.product.api.form.CommodityForm;
import com.oasis.rx.product.entity.CommodityEntity;
import com.oasis.rx.product.param.CommodityParam;
import com.oasis.rx.product.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("v1/product-commodities")
@Api(description = "商品接口")
public class CommodityController {

  private final CommodityService commodityService;

  /**
   * 添加商品
   *
   * @param form 商品表单
   * @return 是否成功
   */
  @PostMapping
  @ApiOperation("后台-添加商品")
  public ResponseEntity create(@RequestBody CommodityForm form) {
    CommodityParam param = new CommodityParam();
    param.setName(form.getName());
    param.setPrice(form.getPrice());
    param.setQuantity(form.getQuantity());
    param.setOperatorId(form.getOperatorId());

    return Match(this.commodityService.create(param)).of(
        Case($(1), () -> new ResponseEntity<>(HttpStatus.CREATED)),
        Case($(0), () -> new ResponseEntity<>(HttpStatus.BAD_REQUEST))
    );
  }

  /**
   * 删除商品
   *
   * @param id 商品id
   * @return 删除状态
   */
  @DeleteMapping("{id}")
  @ApiOperation("后台-删除商品")
  public ResponseEntity delete(@PathVariable("id") String id) {
    int count = this.commodityService.deleted(id);
    if (1 != count) {
      return Restful.badRequest();
    }
    return Restful.noContent();
  }

  /**
   * 修改商品
   *
   * @param form 商品表单
   * @return 修改状态
   */
  @PutMapping
  @ApiOperation("后台-修改商品")
  public ResponseEntity edit(@RequestBody CommodityForm form) {
    CommodityParam param = new CommodityParam();
    param.setId(form.getId());
    param.setName(form.getName());
    param.setPrice(form.getPrice());
    param.setQuantity(form.getQuantity());
    param.setOperatorId(form.getOperatorId());

    return Match(this.commodityService.update(param)).of(
        Case($(1), () -> new ResponseEntity<>(HttpStatus.OK)),
        Case($(0), () -> new ResponseEntity<>(HttpStatus.BAD_REQUEST))
    );
  }

  /**
   * 根据商品id查询商品信息
   *
   * @param id 商品id
   * @return 商品信息
   */
  @GetMapping(params = "id")
  @ApiOperation("后台-根据商品id查询商品信息")
  public ResponseEntity show(@RequestParam("id") String id) {
    CommodityEntity entity = this.commodityService.get(id);
    if (nonNull(entity)) {
      return Restful.ok(entity);
    } else {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }
}
