package io.studio.auth.controller.vo.biz.farmer;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
/**
 * Date:2023/12/7 9:19
 *
 * @Author:poboking
 */
@Schema(description = "用户管理 - 获取种植详情")
@Data
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode
public class CropDetailsRespVO {

    @Schema(description = "总种植亩数",required = true,example = "1230")
    @NotNull(message = "总种植亩数不为空")
    private Integer cropTotalArea;

    @Schema(description = "合作社种植亩数",required = true,example = "1000")
    @NotNull(message = "合作社种植亩数不为空")
    private Integer cropArtelArea;

    @Schema(description = "农村种植亩数",required = true,example = "230")
    @NotNull(message = "农村种植亩数不为空")
    private Integer cropVillageArea;
}
