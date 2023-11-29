package io.studio.tweet.controller.vo.industry.info;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/20 17:39
 *
 * @Author:poboking
 */
@Schema(description = "首页管理 - 资讯推文创建")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class IndustryInfoCreateReqVO extends IndustryInfoBaseVO{
    @Schema(description = "推荐编号,默认0非推荐,1推荐",required = true,example = "1")
    @NotNull(message = "推荐编号不为空")
    private Integer recommended;
}
