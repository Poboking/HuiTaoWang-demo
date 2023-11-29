package io.studio.interflow.controller.comment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/24 21:05
 *
 * @Author:poboking
 */
@Data
public class CommentsBaseVO {
    @Schema(description = "动态ID",required = true,example = "11")
    @NotNull(message = "动态ID不为空")
    private Long postId;

    @Schema(description = "发布者ID",required = true,example = "10")
    @NotNull(message = "发布者ID不为空")
    private Long userId;

    @Schema(description = "评论内容",required = true,example = "Test is 测试")
    @NotNull(message = "评论内容不为空")
    private String content;
}
