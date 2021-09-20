package com.practice.slasher.service.exception;

/**
 * Excepción personalizada en la que se espera capturar
 * entidades de tipo {@code User} null.
 */
public class UserIsNullException extends RuntimeException {

    public static UserIsNullException of() {
        return new UserIsNullException();
    }

    public UserIsNullException(String message) {
        super(message);
    }

    public UserIsNullException() {
        super("User is null");
    }
}
