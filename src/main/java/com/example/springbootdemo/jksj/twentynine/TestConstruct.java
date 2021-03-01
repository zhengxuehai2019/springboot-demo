package com.example.springbootdemo.jksj.twentynine;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RestController
@Slf4j
@RequestMapping("/aaaaaaaaa")
public class TestConstruct {
    protected String name;
    private boolean isMan;

    private boolean isWoman(){
        return false;
    }
    public static void main(String[] args) {
//        new TestConstruct("zs",true);
//        new TestConstruct("zs",true){
//            protected boolean isWoman(){
//                return true;
//            }
//        };


//        String json = "{\"errcode\":40029,\"err_msg\":\"invalid code, hints: [ req_id: eeIaPsNre-aBHNAA ]\"}";
//        TestJson testJson = JSONObject.parseObject(json, TestJson.class);
//        System.out.println("反序列化：" + testJson);
//
//        String jsonP = JSON.toJSONString(testJson);
//        System.out.println("序列化：" + jsonP);


        Set<Long> set = new HashSet<>();
        set.add(1l);
        set.add(1l);
        set.add(3l);
        set.add(2l);
        set.add(2l);
        System.out.println("list:" + set.size() + "list:" + set);
        TestJson testJson1 = new TestJson(1,"有效中奖");
        TestJson testJson2 = new TestJson(1,"有效中奖");
        TestJson testJson3 = new TestJson(1,"有效中奖");
        TestJson testJson4 = new TestJson(1,"有效中奖");
        TestJson testJson5 = new TestJson(1,"有效中奖");
        TestJson testJson6 = new TestJson(1,"有效中奖");
        TestJson testJson7 = new TestJson(1,"有效中奖");
        TestJson testJson8 = new TestJson(1,"有效中奖");
        TestJson testJson9 = new TestJson(1,"有效中奖");
        TestJson testJson10 = new TestJson(0,"有效中奖有效中奖有效中奖");
        List<TestJson> jsons = new ArrayList<>();
        jsons.add(testJson1);
        jsons.add(testJson2);
        jsons.add(testJson3);
        jsons.add(testJson4);
        jsons.add(testJson5);
        jsons.add(testJson6);
        jsons.add(testJson7);
        jsons.add(testJson8);
        jsons.add(testJson9);
        jsons.add(testJson10);
        List<String> collect = jsons.stream().filter(e -> e.getErrCode().equals(0)).map(s -> s.getErrMsg()).collect(Collectors.toList());
        System.out.println();
        long count1 = jsons.stream().filter(e -> e.getErrCode().equals(1)).count();

    }
    @Autowired
    HttpServletResponse httpServletResponse;
    @PostMapping("/bbbbbbbbb")
    public Object getObj(){
        Cookie cookie = new Cookie("userName","zs");
        httpServletResponse.addCookie(cookie);
        TestJson testJson = null;
//        try {
            if(true){
                throw new RuntimeException();
            }
            String json = "{\"errcode\":40029,\"err_msg\":\"invalid code, hints: [ req_id: eeIaPsNre-aBHNAA ]\"}";
            testJson = JSONObject.parseObject(json, TestJson.class);
//        }catch (Exception e){
//            log.warn("fail interface ",e);
//            e.printStackTrace();
//        }
        log.info("是否可以继续？？？？？？=============");
        return testJson;
    }
}
