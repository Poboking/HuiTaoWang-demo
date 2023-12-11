package io.studio.auth.controller.vo.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date:2023/12/4 20:03
 *
 * @Author:poboking
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationReqVO {
    private String phoneNumber;
    private String password;
}
