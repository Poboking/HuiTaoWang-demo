package io.studio.interflow.controller.comment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Date:2023/11/24 21:40
 *
 * @Author:poboking
 */
@Schema(description = "评论管理 - 评论响应项")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CommentsRespVO extends CommentsBaseVO {
    @Schema(description = "发布者名称", required = true, example = "小明")
    @NotNull(message = "发布者名称不为空")
    private String authorName;

    @Schema(description = "发布者头像Url", required = true, example = "https://www.kdocs.cn/l/cqYUuL4kIHb6.jpg")
    @NotNull(message = "发布者头像不为空")
    private String authorUrl;

    @Schema(description = "发布时间", required = true, example = "2023-09-05 15:30:00")
    @NotNull(message = " 发布时间不为空")
    private Timestamp sendTime;
}
