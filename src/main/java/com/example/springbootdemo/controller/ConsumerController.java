package com.example.springbootdemo.controller;

import com.example.springbootdemo.controller.service.ExceptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    ExceptionService exceptionService;

    @GetMapping("/get")
    public String getString(@RequestParam("msg") String msg) throws Exception {
        if(true){
            throw new Exception("我是系统异常");
        }
        log.info("sttatatat param:{}",msg);
        return msg;
    }

    @GetMapping("/exception")
    public String getString(HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        log.info("进入接口：：");
        return "success";
    }
}
