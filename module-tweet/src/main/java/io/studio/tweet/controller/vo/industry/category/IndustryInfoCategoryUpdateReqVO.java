package io.studio.tweet.controller.vo.industry.category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Date:2023/11/21 9:01
 *
 * @Author:poboking
 */

@Schema(description = "首页管理 - 资讯推文类别更新")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IndustryInfoCategoryUpdateReqVO extends IndustryInfoCategoryBaseVO{
}
