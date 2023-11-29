package io.studio.mall.controller.cart.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/26 21:13
 *
 * @Author:poboking
 */
@Schema(description = "电商管理 - 购物车项更新")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CartItemUpdateReqVO extends CartItemBaseVO{
    @Schema(description = "购物车项ID",required = true,example = "1")
    @NotNull(message = "购物车项ID不为空")
    private Long itemId;
}
