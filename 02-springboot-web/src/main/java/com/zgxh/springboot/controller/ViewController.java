package com.zgxh.springboot.controller;

import com.zgxh.springboot.model.User;
import com.zgxh.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 返回视图学习。
 *
 * @author Yu Yang
 * @create 2020-02-18 16:11
 */
@Controller     // 因为返回视图，所以不能用RestController
@RequestMapping("/view")
public class ViewController {

    @Autowired
    private UserService userService;

    @GetMapping("/jsp")
    // Controller先接收一个实体类，再把实体类传递的信息转发到jsp，这个实体类可以是Model也可以是自己的类，在函数执行前MVC会初始化这个类
    public String jspRequest(Model model, User user) {
        // 使用Model model传入实体类时，可添加Map对象，用于传递信息，在jsp中使用key值"zgxh"取其对应的value
        model.addAttribute("zgxh", "真帅！");

        // 使用其他实体类转发消息
        user.setName("zgxh");
        user.setId(1);

        // 默认为请求转发，其中视图前后缀可以在application.properties中添加视图配置;注意要在pom.xml中添加编译配置，把jsp页面编译到/target中去
        return "index.jsp";
    }

    @GetMapping("/html/{id}")
    public ModelAndView beetlRequest(@PathVariable int id) { // 使用ModelAndView代替Model
        ModelAndView view = new ModelAndView(); // 可以当成参数，也可以在函数体内自行初始化
        User user = userService.selectById(id);

        view.addObject("idSelect", user);
        view.setViewName("/userViewTest.jsp"); // 设置视图名称

        return view;
    }
}
