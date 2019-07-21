package com.xuanc.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * ClassName    spring-boot-04-web-restfulcrud-HelloController
 * Description  
 *
 * @author      xuanc
 * @date        2019/7/20 下午5:01
 * @version     1.0
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好世界</h1>");
        map.put("users", Arrays.asList("张三", "李四", "王五"));
        return "success";
    }

}
