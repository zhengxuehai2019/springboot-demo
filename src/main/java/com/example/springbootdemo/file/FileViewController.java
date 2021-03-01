package com.example.springbootdemo.file;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file/view")
public class FileViewController {
    //打开所有jsp页面
    @RequestMapping("/upload/{view}")
    public String html(@PathVariable("view")String view){
        return view;
    }
}
