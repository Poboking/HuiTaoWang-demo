package io.studio.auth.controller.vo.biz.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Date:2023/12/4 23:05
 *
 * @Author:poboking
 */
@Schema(description = "用户管理 - 用户注册")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserRegisterReqVO extends UserBaseVO{
    @Schema(description = "用户类型:NORMAL 普通用户 FARMER 桃农 EXPERT 专家学者 ADMIN 管理员",defaultValue = "NORMAL",required = true,example = "NORMAL")
    @NotBlank(message = "用户类型不为空")
    private String userType;

    @Schema(description = "所在村ID(桃农)", required = false,example = "1231")
    private Integer plantId;

    @Schema(description = "经济社ID(桃农)", required = false,example = "1231")
    private Integer villageId;

    @Schema(description = "种植种类ID(桃农)", required = false,example = "1231")
    private Integer cooperationId;

    @Schema(description = "种植面积(桃农)",required = false,example = "123")
    private Integer cropArea;

    @Schema(description = "种植棵数(桃农)",required = false,example = "110")
    private Integer cropCount;

    @Schema(description = "所在科研机构/院校(专家学者)",required = false,example = "中科院")
    private String institution;

    @Schema(description = "研究方向(专家学者)",required = false,example = "粗粮种植")
    private String researchField;

    @Schema(description = "所在部门(管理员)",required = false,example = "监控部门")
    private String department;
}
