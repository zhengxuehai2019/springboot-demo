package com.example.springbootdemo.controller.service.impl;

import com.example.springbootdemo.controller.service.ExceptionService;
import com.example.springbootdemo.util.exception.BusinessException;
import com.example.springbootdemo.util.response.ResponseEnum;
import org.springframework.stereotype.Service;

@Service
public class ExceptionServiceImpl implements ExceptionService {
    @Override
    public String testException() {
        if(true){
            throw new BusinessException(ResponseEnum.PARAM_ERROR);
        }
        return null;
    }
}
