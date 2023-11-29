package io.studio.mall.controller.order.vo.order;

import io.studio.mall.controller.order.vo.item.OrderItemRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Date:2023/11/27 0:31
 *
 * @Author:poboking
 */
@Schema(description = "电商管理 - 订单响应")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OrderRespVO extends OrderBaseVO{
    @Schema(description = "订单编号",required = true,example = "13021")
    @NotNull(message = "订单编号不为空")
    private Long orderId;

    @Schema(description = "交易ID",required = true,example = "2FE7AAB9-5187-F65E-9CFC-CB41B06EEFC4")
    @NotNull(message = "交易ID不为空")
    private String transactionId;

    @Schema(description = "优惠码",required = true,example = "A16F69CA-2F17-6702-61DF-F52FB3DCF29D")
    @NotNull(message = "优惠码不为空")
    private String couponCode;

    @Schema(description = "总金额",required = true,example = "120.00")
    @NotNull(message = "总金额不为空")
    private BigDecimal totalAmount;

    @Schema(description = "创建时间",required = true,example = "2023-11-24 15:57:42")
    @NotNull(message = "创建时间不为空")
    private Timestamp createdAt;

    @Schema(description = "订单状态",required = true,example = "已发货")
    @NotNull(message = "订单状态不为空")
    private String status;

    @Schema(description = "订单商品项",required = true)
    @NotNull(message = "订单商品项不为空")
    private List<OrderItemRespVO> products;
}
