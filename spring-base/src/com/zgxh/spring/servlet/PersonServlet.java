package com.zgxh.spring.servlet;

import com.zgxh.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Yu Yang
 * @create 2020-06-06 16:18
 */
@Controller
public class PersonServlet {

    @Autowired
    private PersonService personService;

    public void save() {
        System.out.println("PersonServlet 调用 PersonService 进行 save...");
        personService.save();
    }
}
