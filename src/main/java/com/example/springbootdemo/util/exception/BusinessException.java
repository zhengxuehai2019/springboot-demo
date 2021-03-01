package com.example.springbootdemo.util.exception;

import com.example.springbootdemo.util.response.ResponseEnum;
import lombok.Data;

@Data
public class BusinessException extends RuntimeException{

    private ResponseEnum responseEnum;

    public BusinessException(ResponseEnum responseEnum) {
        this.responseEnum = responseEnum;
    }

    public ResponseEnum getResponseEnum() {
        return responseEnum;
    }

    public void setResponseEnum(ResponseEnum responseEnum) {
        this.responseEnum = responseEnum;
    }
}
