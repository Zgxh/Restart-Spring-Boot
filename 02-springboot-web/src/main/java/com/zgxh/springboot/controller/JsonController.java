package com.zgxh.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zgxh.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    /* 下面用Jackson进行序列化和反序列化 */
    @Autowired
    ObjectMapper objectMapper; // ObjectMapper 是Jackson进行序列化和反序列化的工具

    // 树遍历的方式
    @GetMapping(value = "/tree.json")
    public String readTree() throws JsonProcessingException, IOException {
        String json = "{\"name\":\"zgxh\",\"id\":\"122\"}"; // 模拟传入的JSON字符串
        JsonNode node = objectMapper.readTree(json); // 返回JsonNode作为根节点
        String name = node.get("name").asText();
        int id = node.get("id").asInt();
        return "name:" + name + ", id:" + id;
    }

    // 采用DataBind方式
    @GetMapping("/databind.json")
    public String dataBind() throws JsonProcessingException, IOException {
        String json = "{\"name\":\"zgxh\",\"id\":\"122\"}"; // 模拟传入的JSON字符串
        User user = objectMapper.readValue(json, User.class); // 使用readValue来反序列化JSON到POJO
        // 把POJO序列化成JSON可以使用writeValueAsString
        return "name:" + user.getName() + ", id:" + user.getId();
    }

    /* 集合的反序列化 */
    @GetMapping(value = "/collection.json")
    public String collection(@RequestBody List<User> list) { // 使用@RequestBody把JSON自动映射到方法参数，
        // 泛型类型User会被编译到字节码中从而被识别为User类型，每个json体反序列化到一个User对象
        StringBuilder sb = new StringBuilder();
        for (User user : list) {
            sb.append(user.getName()).append(" ");
        }
        return sb.toString();
    }

    // 另一种方式
    @GetMapping(value = "/collection1.json")
    public int collection1(@RequestBody String json) throws JsonProcessingException, IOException {
        JavaType type = objectMapper.getTypeFactory().constructParametricType(List.class, User.class); // 使用JavaType来提供泛型信息
        List<User> list = objectMapper.readValue(json, type); // 不能直接用List.class，因为泛型类型没有指定
        return list.size();
    }
}
