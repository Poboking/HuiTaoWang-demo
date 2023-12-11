package io.studio.auth.controller.vo.biz.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Date:2023/12/5 11:30
 *
 * @Author:poboking
 */
@Schema(description = "用户管理 - 用户更新个人信息")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserUpdateReqVO extends UserBaseVO {
    @Schema(description = "用户ID", required = true, example = "1231231")
    @NotNull(message = "用户ID不为空")
    private Long userId;

    @Schema(description = "用户昵称", required = true, example = "不吃葡萄吐葡萄籽")
    @NotBlank(message = "用户昵称不为空")
    private String nickname;

    @Schema(description = "用户头像Url", required = true, example = "https://developer.mozilla.org")
    @NotBlank(message = "用户头像不为空")
    private String avatar;

    @Schema(description = "用户性别: 男, 女, 保密", required = true, example = "保密")
    @NotBlank(message = "用户性别不为空")
    private String gender;
}
