package io.studio.course.controller.category.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Date:2023/11/23 16:55
 *
 * @Author:poboking
 */

@Schema(description = "课程管理 - 课程类别更新")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CourseCategoryUpdateReqVO extends CourseCategoryBaseVO{
}
