package io.studio.auth.common.exception;

/**
 * Date:2023/12/6 10:07
 *
 * @Author:poboking
 */
public class UserAuthenticateException extends RuntimeException{
    public UserAuthenticateException(String message){
        super(message);
    }
}
