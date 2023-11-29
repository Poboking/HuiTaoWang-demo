package io.studio.mall.controller.order.vo.item;

import io.studio.mall.controller.cart.vo.CartItemBaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Date:2023/11/26 21:39
 *
 * @Author:poboking
 */
@Schema(description = "电商管理 - 订单创建 - 订单商品项创建")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OrderItemRespVO extends CartItemBaseVO {
}
