package io.studio.tweet.controller.vo.industry.category;

import io.studio.tweet.controller.vo.industry.info.IndustryInfoBaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Date:2023/11/21 23:30
 *
 * @Author:poboking
 */
@Schema(description = "首页管理 - 资讯类别响应项")
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class IndustryInfoCategoryRespVO extends IndustryInfoCategoryBaseVO {
}
