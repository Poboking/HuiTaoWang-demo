package io.studio.auth.common.exception;


import io.studio.auth.common.exception.enums.GlobalErrorCodeConstants;
import lombok.Data;

/**
 * Date:2023/11/14 11:22
 * 全局错误码，占用 [0, 999], 参见 {@link GlobalErrorCodeConstants}
 * @Author:poboking
 */
@Data
public class ErrorCode {
    /**
     * 错误码
     */
    private final Integer code;
    /**
     * 错误提示
     */
    private final String msg;

    public ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
