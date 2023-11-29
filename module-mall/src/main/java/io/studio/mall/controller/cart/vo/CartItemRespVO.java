package io.studio.mall.controller.cart.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Date:2023/11/27 9:19
 *
 * @Author:poboking
 */
@Schema(description = "电商管理 - 购物车项响应")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CartItemRespVO extends CartItemBaseVO{
    @Schema(description = "商品名称",required = true,example = "桃子")
    @NotNull(message = "商品名称不为空")
    private String name;

    @Schema(description = "商品价格",required = true,example = "1.20")
    @NotNull(message = "商品价格不为空")
    private BigDecimal price;

    @Schema(description = "购物车项ID",required = true,example = "1")
    @NotNull(message = "购物车项ID不为空")
    private Long itemId;

    @Schema(description = "商品图片Url",required = false,example = "https://www.kdocs.cn/l/cqYUuL4kIHb6")
    @Nullable
    private String imageUrl;
}
