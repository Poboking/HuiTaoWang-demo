package io.studio.mall.controller.order.vo.order;

import io.studio.mall.controller.cart.vo.CartItemSubmitOrderReqVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Date:2023/11/26 21:41
 *
 * @Author:poboking
 */
@Schema(description = "电商管理 - 订单创建")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OrderCreateReqVO extends OrderBaseVO {
    @Schema(description = "订单商品项",required = true)
    @NotNull(message = "订单商品项不为空")
    private List<CartItemSubmitOrderReqVO> products;

    @Schema(description = "优惠码",required = true,example = "A16F69CA-2F17-6702-61DF-F52FB3DCF29D")
    @NotNull(message = "优惠码不为空")
    private String couponCode;

    @Schema(description = "地址行1",required = true,example = "河北省邯郸市邯郸县")
    @NotNull(message = "地址行1不为空")
    private String addressLine1;

    @Schema(description = "地址行2",required = true,example = "丰灵路45号")
    @NotNull(message = "地址行2不为空")
    private String addressLine2;

    @Schema(description = "邮编码",required = true,example = "225189")
    @NotNull(message = "邮编码不为空")
    private String zip;

    @Schema(description = "手机号",required = true,example = "13923777439")
    @NotNull(message = "手机号不为空")
    private String phone;

    @Schema(description = "收货人姓名",required = true,example = "汪小明")
    @NotNull(message = "收货人姓名不为空")
    private String name;
}
