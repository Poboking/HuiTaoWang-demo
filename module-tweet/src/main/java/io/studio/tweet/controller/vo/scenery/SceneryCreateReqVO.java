package io.studio.tweet.controller.vo.scenery;

import io.studio.tweet.dal.dataobject.SceneryDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Date:2023/11/21 9:30
 *
 * @Author:poboking
 */
@Schema(description = "首页管理 - 桃园风光推文创建")
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class SceneryCreateReqVO extends SceneryBaseVO {
}
