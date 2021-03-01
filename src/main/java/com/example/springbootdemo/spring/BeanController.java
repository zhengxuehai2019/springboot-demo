package com.example.springbootdemo.spring;

import com.example.springbootdemo.util.response.ResponseEnum;
import com.example.springbootdemo.util.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BeanController {
    @GetMapping("/getBean")
    public ResponseResult getBean(@RequestHeader()Integer age){
        log.info("start to /getBean");
        Phone huaWeiPhone = BeanUtil.getBean("huaWeiPhone");
        huaWeiPhone.makePhone();
        System.out.println("saaaaaafdsadfsdafe" + " bbbbbbbbbbbdb");
//        return ResponseResult.buildError(ResponseEnum.SYSTEM_ERROR);
//        return ResponseResult.build("0022","请求失败",huaWeiPhone);
        return ResponseResult.success(ResponseEnum.SUCCESS,huaWeiPhone);
    }
}
