package com.zgxh.spring.test;

import com.zgxh.spring.servlet.PersonServlet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author Yu Yang
 * @create 2020-06-06 23:06
 */
@ContextConfiguration(locations = "/conf/annotation-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class IoCTest {

    @Autowired
    private PersonServlet personServlet;

    @Test
    public void test() {
        System.out.println(personServlet);
    }
}