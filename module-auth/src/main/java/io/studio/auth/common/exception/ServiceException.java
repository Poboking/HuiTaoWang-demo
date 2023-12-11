package io.studio.auth.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Date:2023/11/14 11:40
 * 业务逻辑异常 Exception
 * @Author:poboking
 */
@EqualsAndHashCode(callSuper = true)
@Data
public final class ServiceException extends RuntimeException{
    /**
     * 全局错误码
     */
    private Integer code;
    /**
     * 错误提示
     */
    private String message;

    /**
     * 空构造方法，避免反序列化问题
     */
    public ServiceException(){}
    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public ServiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public ServiceException setCode(Integer code){
        this.code = code;
        return this;
    }

    public ServiceException setMessage(String message){
        this.message = message;
        return this;
    }
}
