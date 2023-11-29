package io.studio.course.controller.category.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Date:2023/11/23 16:57
 *
 * @Author:poboking
 */
@Schema(description = "课程管理 - 课程类别响应项")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CourseCategoryRespVO extends CourseCategoryBaseVO {
}
