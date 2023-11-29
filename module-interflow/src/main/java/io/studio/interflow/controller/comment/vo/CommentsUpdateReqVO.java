package io.studio.interflow.controller.comment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/24 21:37
 *
 * @Author:poboking
 */
@Schema(description = "评论管理 - 更新评论项")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CommentsUpdateReqVO extends CommentsBaseVO {
    @Schema(description = "评论ID", required = true, example = "1")
    @NotNull(message = "评论ID不为空")
    private Long commentId;
}
