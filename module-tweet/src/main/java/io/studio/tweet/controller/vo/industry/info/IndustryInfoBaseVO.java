package io.studio.tweet.controller.vo.industry.info;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.security.Timestamp;

/**
 * Date:2023/11/20 17:14
 *
 * @Author:poboking
 */
@Data
public class IndustryInfoBaseVO {

    @Schema(description = "用户ID",required = true,example = "1")
    @NotNull(message = "用户ID不为空")
    private Long userId;

    @Schema(description = "推文类别ID",required = true,example = "1")
    @NotNull(message = "推文类别ID不为空")
    private Long categoryId;

    @Schema(description = "推文标题",required = true)
    @NotNull(message = "推文标题不为空")
    private String title;

    @Schema(description = "推文图片URL")
    private String image;

    @Schema(description = "推文内容",required = true)
    @NotNull(message = "推文内容不为空")
    private String content;
}
