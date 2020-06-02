package com.zgxh.jsonandajax.controller;

import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public Map ajaxTest(@RequestParam String name, @RequestParam int age) {
        System.out.println("收到请求参数，name : " + name + ", age : " + age);
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);
        return map;
    }
}
