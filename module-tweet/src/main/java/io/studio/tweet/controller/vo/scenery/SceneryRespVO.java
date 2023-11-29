package io.studio.tweet.controller.vo.scenery;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Date:2023/11/22 11:48
 *
 * @Author:poboking
 */
@Schema(description = " 首页管理 - 桃园风光响应属性")
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class SceneryRespVO extends SceneryBaseVO{
}
