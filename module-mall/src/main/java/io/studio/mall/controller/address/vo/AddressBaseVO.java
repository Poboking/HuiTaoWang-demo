package io.studio.mall.controller.address.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/27 9:10
 *
 * @Author:poboking
 */
@Data
public class AddressBaseVO {
    @Schema(description = "用户ID",required = true,example = "120")
    @NotNull(message = "用户ID不为空")
    private Long userId;

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
