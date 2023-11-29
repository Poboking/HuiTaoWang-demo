package io.studio.interflow.controller.post.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Date:2023/11/24 21:12
 *
 * @Author:poboking
 */
@Schema(description = "动态管理 - 创建动态项")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class InterflowPostCreateReqVO extends InterflowPostBaseVO {
}
