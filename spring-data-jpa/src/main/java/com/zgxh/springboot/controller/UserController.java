package com.zgxh.springboot.controller;

import com.zgxh.springboot.entity.User;
import com.zgxh.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yu Yang
 * @create 2020-03-06 13:54
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/finduser/{id}")
    @ResponseBody
    public String findUser(@PathVariable Integer id) {
        return userService.findUserById(id).getName();
    }

    @GetMapping(value = "/getuser/{name}/{deptid}")
    @ResponseBody
    public User findUser(@PathVariable("name") String name, @PathVariable("deptid") Integer departmentId) {
        return userService.findUser(name, departmentId);
    }

    @PostMapping(value = "/adduser")
    @ResponseBody
    public String addUser(@RequestBody User user) {
        return userService.addUser(user).toString();
    }

    @GetMapping(value = "/getallusers")
    @ResponseBody
    public List<User> getAllUser(Integer page, Integer size) {
        return userService.getAllUser(page, size);
    }

    @GetMapping(value = "/pagequery")
    @ResponseBody
    public List<User> pageQuery(int deptId, int page, int size) {
        Page<User> users = userService.queryUser(deptId, PageRequest.of(page, size));
        return users.getContent();
    }

    @GetMapping(value = "/example/{name}")
    public List<User> getUserByExample(@PathVariable String name) {
        return userService.getUserByExample(name);
    }
}
