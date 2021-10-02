package com.webperside.blogsite.exception;

import com.webperside.blogsite.dto.common.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RestException.class)
    public BaseResponse<Object> handleRestException(RestException ex){
        return BaseResponse.of(ex);
    }
}
