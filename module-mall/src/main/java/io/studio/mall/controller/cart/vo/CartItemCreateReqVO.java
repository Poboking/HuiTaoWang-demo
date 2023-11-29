package io.studio.mall.controller.cart.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Date:2023/11/26 21:10
 *
 * @Author:poboking
 */
@Schema(description = "电商管理 - 购物车项创建")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CartItemCreateReqVO extends CartItemBaseVO{
}
