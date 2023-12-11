package io.studio.auth.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Date:2023/12/5 16:14
 *
 * @Author:poboking
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UserRegistrationException extends RuntimeException{
    public UserRegistrationException(String message){
        super(message);
    }
}

