package io.studio.interflow.controller.post.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Date:2023/11/24 21:17
 *
 * @Author:poboking
 */
@Schema(description = "动态管理 - 动态响应项")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class InterflowPostRespVO extends InterflowPostBaseVO {
    @Schema(description = "动态ID",required = true,example = "1")
    @NotNull(message = "动态ID不为空")
    private Long postId;

    @Schema(description = "发布者名称", required = true, example = "小明")
    @NotNull(message = "发布者名称不为空")
    private String authorName;

    @Schema(description = "发布者头像Url", required = true, example = "https://www.kdocs.cn/l/cqYUuL4kIHb6.jpg")
    @NotNull(message = "发布者头像不为空")
    private String avatarUrl;

    @Schema(description = "是否点赞(T&F)", required = true, example = "true")
    @NotNull(message = "是否点赞不为空")
    private Boolean isLike;

    @Schema(description = "评论条数", required = true, example = "12")
    @NotNull(message = "评论条数不为空")
    private Integer commentNum;

    @Schema(description = "点赞数", required = true, example = "13")
    @NotNull(message = "点赞数不为空")
    private Integer likeNum;

    @Schema(description = "动态发布时间", required = true, example = "2023-09-11 02:52:42")
    @NotNull(message = "发布时间不为空")
    private Timestamp sendTime;
}
