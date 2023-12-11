package io.studio.auth.controller.vo.biz.user;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;



/**
 * Date:2023/12/5 11:40
 *
 * @Author:poboking
 */
@Schema(description = "用户管理 - 桃农更新")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserFarmerUpdateReqVO extends UserBaseVO {
    @Schema(description = "所在村ID", required = true,example = "1231")
    @NotNull(message = "所在村ID不为空")
    private Integer plantId;

    @Schema(description = "经济社ID", required = true,example = "1231")
    @NotNull(message = "经济社ID不为空")
    private Integer villageId;

    @Schema(description = "种植种类ID", required = true,example = "1231")
    @NotNull(message = "种植种类ID不为空")
    private Integer cooperationId;

    @Schema(description = "种植面积",required = true,example = "123")
    @NotNull(message = "种植面积不为空")
    private Integer cropArea;

    @Schema(description = "种植棵数",required = true,example = "110")
    @NotNull(message = "种植棵数不为空")
    private Integer cropCount;

}
