package io.studio.mall.controller.order.vo.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/27 0:28
 *
 * @Author:poboking
 */
@Schema(description = "电商管理 - 订单更新")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OrderUpdateReqVO extends OrderBaseVO{
    @Schema(description = "订单编号",required = true,example = "32131230")
    @NotNull(message = "订单编号不为空")
    private Long orderId;

    @Schema(description = "交易ID",required = true,example = "2FE7AAB9-5187-F65E-9CFC-CB41B06EEFC4")
    @NotNull(message = "交易ID不为空")
    private String transactionId;

    @Schema(description = "订单状态",required = true,example = "已发货")
    @NotNull(message = "订单状态不为空")
    private String status;
}
