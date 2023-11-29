package io.studio.interflow.controller.post.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/24 21:04
 *
 * @Author:poboking
 */
@Data
public class InterflowPostBaseVO {
    @Schema(description = "发布人ID", required = true, example = "11")
    @NotNull(message = "发布人ID不为空")
    private Long userId;

    @Schema(description = "动态内容", required = true, example = "动态文本")
    @NotNull(message = "动态内容不为空")
    private String text;

    @Schema(description = "媒体文件", required = true, example = "https://www.kdocs.cn/l/cqYUuL4kIHb6")
    @Nullable
    private String media;
}
