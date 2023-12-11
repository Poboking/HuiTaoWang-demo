package io.studio.auth.controller.vo.biz.expert;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;



/**
 * Date:2023/12/7 8:58
 *
 * @Author:poboking
 */
@Schema(description = "用户管理 - 获取专家列表")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExpertsScholarsRespVO extends ExpertsScholarsBassVO {
    @Schema(description = "用户头像",required = true,example = "https://ydlunacommon-cdn.nosdn.127.net/f16f9eb84addf9372d6592e7c3f8cfe3.jpg?")
    @NotBlank(message = "用户头像不为空")
    private String avatarUrl;
}
