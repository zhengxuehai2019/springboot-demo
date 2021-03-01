package com.example.springbootdemo.util.exception;

import com.example.springbootdemo.util.response.ResponseEnum;
import com.example.springbootdemo.util.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionsHandler {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseResult javaExceptionHandler(Exception exception){
        log.error("系统异常捕获",exception);
        return ResponseResult.error(ResponseEnum.SYSTEM_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ResponseResult businessException(BusinessException businessException){
        log.error("业务异常捕获",businessException);
        String code = businessException.getResponseEnum().getCode();
        String msg = businessException.getResponseEnum().getMsg();
        return ResponseResult.build(code,msg);
    }
}
