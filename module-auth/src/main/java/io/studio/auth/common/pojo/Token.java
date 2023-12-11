package io.studio.auth.common.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * Date:2023/12/5 16:06
 *
 * @Author:poboking
 */
@Data
@Builder
public class Token {
    private String token;
}
