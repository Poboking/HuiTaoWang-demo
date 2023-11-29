package io.studio.mall.controller.address.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/27 9:14
 *
 * @Author:poboking
 */
@Schema(description = "电商管理 - 地址更新")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AddressUpdateReqVO extends AddressBaseVO{
    @Schema(description = "地址ID",required = true,example = "321211")
    @NotNull(message = "地址ID不为空")
    private Long addressId;
}
