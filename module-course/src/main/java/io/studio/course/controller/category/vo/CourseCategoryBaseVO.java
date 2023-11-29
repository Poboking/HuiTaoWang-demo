package io.studio.course.controller.category.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/23 16:50
 *
 * @Author:poboking
 */
@Data
public class CourseCategoryBaseVO {
    @Schema(description = "类别ID",required = false,example = "1")
//    @NotNull(message = "类别ID不为空")
    private Long categoryId;

    @Schema(description = "类别名称",required = true,example = "课程类别")
    @NotNull(message = "课程类别不为空")
    private String categoryName;
}
