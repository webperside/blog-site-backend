package com.webperside.blogsite.enums.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorEnum {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 999, "Internal Server Error"),
    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, 1001, "user.already_exists");

    private final HttpStatus status;
    private final Integer code;
    private final String message;

    ErrorEnum(HttpStatus status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
