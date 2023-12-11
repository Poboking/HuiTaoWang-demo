package io.studio.auth.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Date:2023/12/7 10:23
 *
 * @Author:poboking
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UserUpdateException extends RuntimeException{
    public UserUpdateException(String message){
        super(message);
    }
}
