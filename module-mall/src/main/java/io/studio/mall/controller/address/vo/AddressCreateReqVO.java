package io.studio.mall.controller.address.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Date:2023/11/27 9:12
 *
 * @Author:poboking
 */
@Schema(description = "电商管理 - 地址创建")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AddressCreateReqVO extends AddressBaseVO{
}
