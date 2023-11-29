package io.studio.tweet.controller.vo.scenery;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/21 9:32
 *
 * @Author:poboking
 */
@Schema(description = "首页管理 - 桃园风光推文更新")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SceneryUpdateReqVO extends SceneryBaseVO{
    @Schema(description = "桃园风光推文ID",required = true,example = "1")
    @NotNull(message = "推文ID不为空")
    private Long sceneryId;
}
