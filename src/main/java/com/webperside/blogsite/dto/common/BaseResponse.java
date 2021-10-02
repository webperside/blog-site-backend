package com.webperside.blogsite.dto.common;

import com.webperside.blogsite.exception.RestException;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BaseResponse<T> implements Serializable {

    public enum ResponseType {
        SUCCESS, ERROR
    }

    private static final long serialVersionUID = 1L;
    private Long timestamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC); // todo
    private String messageType;
    private String message;
    private Integer code;
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(ResponseType type, String message, Integer code) {
        this.messageType = type.name();
        this.message = message;
        this.code = code;
    }

    public BaseResponse(ResponseType type) {
        this.messageType = type.name();
    }

    public BaseResponse(ResponseType type, T data) {
        this.messageType = type.name();
        this.data = data;
    }

    public BaseResponse(Long timestamp, String messageType, String message, Integer code, T data) {
        this.timestamp = timestamp;
        this.messageType = messageType;
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public static BaseResponse<Object> of(RestException restException) {
        return new BaseResponse<>(ResponseType.ERROR, restException.getMessage(), restException.getCode());
    }

    public static BaseResponse<Object> of(Exception e){
        return new BaseResponse<>(ResponseType.ERROR, e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    public static <T> BaseResponse<T> put(T object){
        return new BaseResponse<>(ResponseType.SUCCESS, object);
    }

    public static BaseResponse<Object> success(){
        return new BaseResponse<>(ResponseType.SUCCESS);
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public BaseResponse<T> setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getMessageType() {
        return messageType;
    }

    public BaseResponse<T> setMessageType(String messageType) {
        this.messageType = messageType;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public BaseResponse<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public BaseResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "timestamp=" + timestamp +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
