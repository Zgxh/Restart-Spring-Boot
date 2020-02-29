package com.zgxh.springboot.controller;

import com.zgxh.springboot.model.User;
import com.zgxh.springboot.service.DaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yu Yang
 * @create 2020-02-29 19:46
 */
@Controller
@RequestMapping(value = "/dao")
public class DaoTestController {

    /**
     * 采用DAO方式进行数据库查询测试，对应DaoService, UserDao类, 这里没有使用DAO框架
     */

    @Autowired
    DaoService daoService;

    @GetMapping("/")
    @ResponseBody
    public int getUserNum() {
        return daoService.getUserNum();
    }

    @GetMapping("/{id}.json")
    @ResponseBody
    public User selectUserById(@PathVariable Integer id) {
        return daoService.selectUserById(id);
    }

    @GetMapping("/all.json")
    @ResponseBody
    public List<User> selectAllUsers() {
        return daoService.selectAllUsers();
    }

    @PostMapping(value = "/insert.json")
    @ResponseBody
    public int insertUser(@RequestBody User user) { // 增加新用户，使用@RequestBody接受json映射到user上
        return daoService.insertUser(user);
    }
}
