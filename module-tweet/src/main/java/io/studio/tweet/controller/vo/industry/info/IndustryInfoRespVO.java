package io.studio.tweet.controller.vo.industry.info;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Date:2023/11/21 15:41
 *
 * @Author:poboking
 */
@Schema(description = "首页管理 - 资讯响应属性")
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class IndustryInfoRespVO extends IndustryInfoBaseVO {

    /**
     * Tips:
     *
     * @NotBlank 和 @NotNull存在些许区别
     * not null针对所有类型的非null判断
     * 而not blank则仅仅针对字符串类型的非null和非空串判断
     */
    @Schema(description = "发布者名称", required = true, example = "李三")
//    @NotBlank(message = "名称不为空")
    private String authorName;

    @Schema(description = "资讯推文ID", required = true, example = "1")
    @NotNull(message = "推文ID不为空")
    private Long infoId;

    @Schema(description = "发布时间", required = true, example = "2023-11-21T07:45:06.123")
    @NotNull(message = "发布时间不为空")
    private LocalDateTime sendTime;
}
