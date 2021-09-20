package com.practice.slasher.service.exception;

/**
 * En caso de no encontrarse un {@code User} se utiliza
 * este Exception personalizado.
 * */
public class UserNotFoundException extends RuntimeException {

    public static UserNotFoundException of(int clave) {
        return new UserNotFoundException(clave);
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(int clave) {
        super(String.format("User with clave %d was not found",
                clave));
    }
}
