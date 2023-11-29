package io.studio.course.controller.course.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/23 17:12
 *
 * @Author:poboking
 */
@Schema(description = "课程管理 - 课程更新")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OnlineCourseUpdateReqVO extends OnlineCourseBaseVO {
    @Schema(description = "课程ID", required = true, example = "1")
    @NotNull(message = "课程ID不为空")
    private Long courseId;
}
