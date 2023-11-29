package io.studio.interflow.controller.like.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/24 21:45
 *
 * @Author:poboking
 */
@Schema(description = "点赞管理 - 新增点赞")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LikesCreateReqVO extends LikesBaseVO {

    @Schema(description = "是否点赞(T&F)",required = true,example = "true")
    @NotNull(message = "like_boolean不为空")
    private Boolean isLike;
}
