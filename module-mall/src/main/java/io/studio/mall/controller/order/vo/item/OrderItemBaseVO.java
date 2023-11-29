package io.studio.mall.controller.order.vo.item;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/26 21:37
 *
 * @Author:poboking
 */
@Data
public class OrderItemBaseVO {
    @Schema(description = "商品ID",required = true,example = "112")
    @NotNull(message = "商品ID不为空")
    private Long productId;

    @Schema(description = "商品数量",required = true,example = "10")
    @NotNull(message = "商品数量不为空")
    private Integer quantity;
}
