package io.studio.mall.controller.order.vo.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/26 21:19
 *
 * @Author:poboking
 */
@Data
public class OrderBaseVO {
    @Schema(description = "用户ID",required = true,example = "10")
    @NotNull(message = "用户ID不为空")
    private Long userId;

    @Schema(description = "地址ID",required = true,example = "321211")
    @NotNull(message = "地址ID不为空")
    private Long addressId;
}
