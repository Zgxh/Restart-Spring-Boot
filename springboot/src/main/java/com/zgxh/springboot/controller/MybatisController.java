package com.zgxh.springboot.controller;

import com.zgxh.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yu Yang
 * @create 2020-02-19 18:55
 */
@RestController
public class MybatisController {

    @Autowired
    private UserService userService;

    @GetMapping("/303")
    // http请求处理流程：http请求映射到Controller的某个方法，调用某个Service业务处理类，Service类调用Mapper与数据库进行交互。
    public Object member() {
        return userService.selectAllUsers();
    }

    @GetMapping(value = "/ajax/user.json", consumes = "application/json") // consumes参数对应HTTP请求的Content-type，使用curl命令测试成功
    public Object ajaxGetUser() {
        return userService.selectById(1);
    }

}
