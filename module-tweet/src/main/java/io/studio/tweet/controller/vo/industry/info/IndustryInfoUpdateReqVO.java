package io.studio.tweet.controller.vo.industry.info;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Date:2023/11/20 20:20
 *
 * @Author:poboking
 */
@Schema(description = "首页管理 - 资讯推文更新")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IndustryInfoUpdateReqVO extends IndustryInfoBaseVO{
    @Schema(description = "推文ID",required = true,example = "1")
    @NotNull(message = "推文ID不为空")
    private Long infoId;
}
