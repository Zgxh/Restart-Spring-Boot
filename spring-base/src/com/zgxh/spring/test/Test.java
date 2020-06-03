package com.zgxh.spring.test;

import com.zgxh.spring.bean.Laboratory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Yu Yang
 * @create 2020-06-03 14:01
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        Laboratory laboratory = (Laboratory) applicationContext.getBean("laboratory");
        Laboratory laboratory1 = (Laboratory) applicationContext.getBean("myFactoryBean");
        System.out.println(laboratory);
    }
}
