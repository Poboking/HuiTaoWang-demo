package io.studio.auth.common.exception;

public class UserAlreadyExistsException extends UserRegistrationException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
