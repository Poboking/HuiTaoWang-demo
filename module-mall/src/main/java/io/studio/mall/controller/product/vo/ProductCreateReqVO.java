package io.studio.mall.controller.product.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Date:2023/11/26 20:52
 *
 * @Author:poboking
 */
@Schema(description = "电商管理 - 商品创建")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductCreateReqVO extends ProductBaseVO{
}
