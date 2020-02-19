package com.zgxh.springboot.controller;

import com.zgxh.springboot.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yu Yang
 * @create 2020-02-17 20:01
 */
@RestController
public class HelloWorldController {

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User helloWorld() {
        User user = new User();
        user.setId(1);
        user.setName("zgxh");

        return user;
    }
}
