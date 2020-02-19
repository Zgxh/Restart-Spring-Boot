package com.zgxh.springboot.controller;

import com.zgxh.springboot.service.MemberService;
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
    private MemberService memberService;

    @GetMapping("/303")
    public Object member() {
        return memberService.getAllMembers();
    }
}
