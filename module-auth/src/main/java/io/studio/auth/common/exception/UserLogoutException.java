package io.studio.auth.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Date:2023/12/6 10:08
 *
 * @Author:poboking
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UserLogoutException extends RuntimeException{
    public UserLogoutException(String message){
        super(message);
    }
}
