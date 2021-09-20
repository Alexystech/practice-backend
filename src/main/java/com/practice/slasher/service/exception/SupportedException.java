package com.practice.slasher.service.exception;

import org.springframework.http.HttpStatus;

/**
 * En este enum se definen los diferentes Exceptions que
 * serán soportados en el backend, si el error es soportado
 * se retornara un error personalizado, en caso de que el error
 * no este definido en este enum, se dirá que es un error no
 * soportado y por lo tanto retornara un Internal Server Error
 * 500.
 *
 * @see com.practice.slasher.configuration.RestExceptionInterceptor
 */
public enum SupportedException {

    USER_IS_NULL(UserIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
    USER_NOT_FOUND(UserNotFoundException.class, HttpStatus.NOT_FOUND);

    private final Class<? extends Throwable> exceptionClass;
    private final HttpStatus status;

    SupportedException(Class<? extends Throwable> exceptionClass, HttpStatus status) {
        this.exceptionClass = exceptionClass;
        this.status = status;
    }

    public Class<? extends Throwable> getExceptionClass() {
        return exceptionClass;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
