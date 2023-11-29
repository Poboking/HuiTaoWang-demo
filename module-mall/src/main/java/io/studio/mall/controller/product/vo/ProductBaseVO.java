package io.studio.mall.controller.product.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


/**
 * Date:2023/11/26 20:48
 *
 * @Author:poboking
 */
@Data
public class ProductBaseVO {
    @Schema(description = "推荐Code,1 推荐 0 非推荐, 默认0",required = true,example = "0")
    @NotNull(message = "推荐Code不为空")
    private Integer recommend;

    @Schema(description = "商品名称",required = true,example = "桃子")
    @NotNull(message = "商品名称不为空")
    private String name;

    @Schema(description = "商品标题",required = true,example = "上坪桃农水蜜桃")
    @NotNull(message = "商品标题不为空")
    private String subhead;

    @Schema(description = "商品价格",required = true,example = "1.20")
    @NotNull(message = "商品价格不为空")
    private BigDecimal price;

    @Schema(description = "商品描述",required = true,example = "上坪桃农水蜜桃")
    @NotNull(message = "商品描述不为空")
    private String description;

    @Schema(description = "商品图片Url",required = false,example = "https://www.kdocs.cn/l/cqYUuL4kIHb6")
    @Nullable
    private String imageUrl;
}
