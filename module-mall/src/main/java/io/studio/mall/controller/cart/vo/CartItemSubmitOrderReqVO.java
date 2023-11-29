package io.studio.mall.controller.cart.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/26 21:44
 *
 * @Author:poboking
 */
@Schema(description = "电商管理 - 订单创建 - 订单商品项创建")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CartItemSubmitOrderReqVO extends CartItemBaseVO{
    @Schema(description = "订单ID",required = true,example = "110")
    @NotNull(message = "订单ID不为空")
    private Long orderId;
}
