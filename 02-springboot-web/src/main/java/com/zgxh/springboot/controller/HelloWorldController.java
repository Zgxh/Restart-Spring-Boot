package com.zgxh.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Yu Yang
 * @create 2020-02-17 20:01
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public @ResponseBody String helloWorld() {
        return "Hello world!";
    }
}
