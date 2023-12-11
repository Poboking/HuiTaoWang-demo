package io.studio.auth.controller.vo.security;

import io.studio.auth.common.pojo.Token;
import io.studio.auth.dal.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date:2023/12/4 20:02
 *
 * @Author:poboking
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRespVO {
    private Long userId;
    private UserType userType;
    private Token token;
}
