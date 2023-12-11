package io.studio.auth.common.exception;

public class EmailFormatException extends UserRegistrationException {
    public EmailFormatException(String message) {
        super(message);
    }
}
