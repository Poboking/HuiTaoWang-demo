package io.studio.auth.controller.vo.biz.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Date:2023/12/5 9:51
 *
 * @Author:poboking
 */
@Schema(description = "用户管理 - 用户登录")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserLoginReqVO extends UserBaseVO{
}
