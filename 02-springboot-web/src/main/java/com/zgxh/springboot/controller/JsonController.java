package com.zgxh.springboot.controller;

import com.zgxh.springboot.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yu Yang
 * @create 2020-02-17 20:01
 */
@RestController
@RequestMapping(value = "/json")
public class JsonController {

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("zgxh");
        return user;
    }

    @GetMapping(value = "/*.json") // 匹配任意字符
    public User anyJson() {
        User user = new User();
        user.setId(1);
        user.setName("zgxh");
        return user;
    }

    // curl "http://localhost:8080/web/json/savejson.json" -H 'Content-Type:application/json' -d '{"name":"hello", "id":1}'
    @PostMapping(value = "/savejson.json") // Post，利用curl模拟POST请求
    public String saveByJson(@RequestBody User user) { // @RequestBody ：请求体是json
        return user.getName();
    }

    // 测试用@Configuration改变序列化日期的格式
    @GetMapping("/date.json")
    public Map getDate() {
        Map map = new HashMap();
        map.put("time", new Date());
        return map;
    }
}
