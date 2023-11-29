package io.studio.interflow.controller.post.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Date:2023/11/24 22:07
 *
 * @Author:poboking
 */
@Schema(description = "动态管理 - 动态分页查询项")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class InterflowPostPageReqVO extends InterflowPostBaseVO{
}
