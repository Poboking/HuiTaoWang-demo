package io.studio.mall.controller.product.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/26 21:03
 *
 * @Author:poboking
 */
@Schema(description = "电商管理 - 商品响应项")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductRespVO extends ProductBaseVO{

    @Schema(description = "商品ID",required = true,example = "111")
    @NotNull(message = "商品ID不为空")
    private Long productId;
}
