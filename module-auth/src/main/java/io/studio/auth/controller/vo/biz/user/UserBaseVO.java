package io.studio.auth.controller.vo.biz.user;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;



/**
 * Date:2023/12/4 22:53
 *
 * @Author:poboking
 */
@Data
public class UserBaseVO {
    @Schema(description = "用户姓名", required = true ,example = "陈三")
    @NotBlank(message = "用户姓名不为空")
    private String name;

    @Schema(description = "电话号码", required = true, example = "13165394537")
    @NotBlank(message = "电话号码不为空")
    private String phoneNumber;
}
