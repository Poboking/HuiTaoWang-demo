package io.studio.interflow.controller.post.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/24 21:14
 *
 * @Author:poboking
 */
@Schema(description = "动态管理 - 更新动态项")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class InterflowPostUpdateReqVO extends InterflowPostBaseVO {
    @Schema(description = "动态ID", required = true, example = "11")
    @NotNull(message = "动态ID不为空")
    private Long postId;
}
