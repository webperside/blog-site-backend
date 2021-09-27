package com.webperside.blogsite.enums.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorEnum {
    ;

    private final HttpStatus status;
    private final Integer code;
    private final String message;

    ErrorEnum(HttpStatus status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
