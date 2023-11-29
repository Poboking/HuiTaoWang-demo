package io.studio.mall.controller.cart.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/26 21:06
 *
 * @Author:poboking
 */
@Data
public class CartItemBaseVO {
    @Schema(description = "用户ID",required = true,example = "1")
    @NotNull(message = "用户ID不为空")
    private Long userId;

    @Schema(description = "商品ID",required = true,example = "111")
    @NotNull(message = "商品ID不为空")
    private Long productId;

    @Schema(description = "商品数量",required = true,example = "12")
    @NotNull(message = "商品数量不为空")
    private Integer quantity;

}
