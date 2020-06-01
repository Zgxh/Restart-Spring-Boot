package com.zgxh.jsonandajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yu Yang
 * @create 2020-06-01 21:02
 */
@Controller
public class AjaxController {

    @RequestMapping("/")
    public String index() {
        return "index.jsp";
    }

    @GetMapping("/refresh")
    @ResponseBody
    public String ajaxTest() {
        return "接收到请求";
    }
}
