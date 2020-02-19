package com.zgxh.springboot.controller;

import com.zgxh.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Yu Yang
 * @create 2020-02-18 16:11
 */
@Controller     // 因为返回jsp页面，所以不能用RestController
public class JSPController {

    @GetMapping("/jsp")
    public String jspRequest(Model model, User user) {     // Controller先接收一个实体类，再把实体类传递的信息转发到jsp，这个实体类可以是Model也可以是自己的类
        // 使用Model model传入实体类时，可添加Map对象，用于传递信息，在jsp中使用key值"zgxh"取其对应的value
        model.addAttribute("zgxh", "真帅！");

        // 使用其他实体类转发消息
        user.setName("zgxh");
        user.setId(1);

        // 默认为请求转发，其中视图前后缀可以在application.properties中添加视图配置;注意要在pom.xml中添加编译配置，把jsp页面编译到/target中去
        return "index.jsp";
    }
}
