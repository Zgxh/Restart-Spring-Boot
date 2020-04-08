package com.zgxh.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityApplication {

    // spring security 默认情况下： 用户名 user， 密码会在终端日志中打印
    // 三种登录的账户配置：
    // 1. 在application.properties 中配置name 和 password
    // 2. 通过创建java配置类，继承 WebSecurityConfigurerAdapter ，然后重写方法。
    // 3. 从数据库加载
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

}
