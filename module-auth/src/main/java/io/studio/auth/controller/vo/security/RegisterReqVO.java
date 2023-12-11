package io.studio.auth.controller.vo.security;

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
public class RegisterReqVO {
    private String phoneNumber;
    private String name;
    private String password;
}