package io.studio.interflow.controller.comment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Date:2023/11/24 21:33
 *
 * @Author:poboking
 */
@Schema(description = "评论管理 - 创建评论项")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CommentsCreateReqVO extends CommentsBaseVO{
}
