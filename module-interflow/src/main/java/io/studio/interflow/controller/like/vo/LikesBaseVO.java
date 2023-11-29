package io.studio.interflow.controller.like.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/24 21:04
 *
 * @Author:poboking
 */
@Data
public class LikesBaseVO {
    @Schema(description = "动态ID",required = true,example = "11")
    @NotNull(message = "动态ID不为空")
    private Long postId;

    @Schema(description = "点赞用户ID",required = true,example = "12")
    @NotNull(message = "点赞用户不为空")
    private Long userId;
}
