package com.zgxh.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yu Yang
 * @create 2020-04-08 15:44
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() { // 浏览器访问 /hello 路径会返回 302 状态码并重定向到 /login 界面
        return "hello!";
    }
}
