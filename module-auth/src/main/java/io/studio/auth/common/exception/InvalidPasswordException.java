package io.studio.auth.common.exception;

public class InvalidPasswordException extends UserRegistrationException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
