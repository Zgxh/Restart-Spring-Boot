package com.zgxh.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Yu Yang
 * @create 2020-04-11 2:06
 */
@Controller
public class staticController {

    @RequestMapping("/login")
    public String login() {
        return "userlogin";
    }
}
