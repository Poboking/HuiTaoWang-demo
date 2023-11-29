package io.studio.course.controller.course.vo;

import io.swagger.models.auth.In;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/23 16:58
 *
 * @Author:poboking
 */
@Data
public class OnlineCourseBaseVO {
    @Schema(description = "专家学者ID",required = true,example = "1")
    @NotNull(message = "专家学者ID不为空")
    private Long expertId;

    @Schema(description = "课程类别ID",required = true,example = "1")
    @NotNull(message = "课程类别ID不为空")
    private Long  categoryId;

    @Schema(description = "课程名称",required = true,example = "桃子种植")
    @NotNull(message = "课程名称不为空")
    private String courseName;

    @Schema(description = "课程Url",required = true,example = "https://www.kdocs.cn/l/cqYUuL4kIHb6")
    @NotNull(message = "课程Url不为空")
    private String courseUrl;

    @Schema(description = "课程描述",required = true,example = "信息信息")
    @NotNull(message = "课程描述不为空")
    private String description;

    @Schema(description = "头像Url",required = true,example = "https://www.kdocs.cn/l/cqYUuL4kIHb6")
    @NotNull(message = "头像Url不为空")
    private String coverUrl;

    @Schema(description = "是否为推荐课程, 默认0非推荐, 1推荐",required = true,example = "0")
    @NotNull(message = "推荐课程不为空")
    private Integer recommended;
}
