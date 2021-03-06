package com.zgxh.spring.test;

import com.zgxh.spring.bean.Laboratory;
import com.zgxh.spring.bean.Person;
import com.zgxh.spring.dao.PersonDao;
import com.zgxh.spring.servlet.PersonServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Yu Yang
 * @create 2020-06-03 14:01
 */
public class Test {

    public static void main(String[] args) {
        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("conf/spring-config.xml");
        // Laboratory laboratory = (Laboratory) applicationContext.getBean("laboratory");
        // Laboratory laboratory1 = (Laboratory) applicationContext.getBean("myFactoryBean");
        // System.out.println(laboratory);
        // Laboratory laboratory2 = applicationContext.getBean("laboratory2", Laboratory.class);
        // System.out.println(laboratory2);

        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("conf/context-test.xml");
        // Person person = applicationContext.getBean("person", Person.class);
        // System.out.println(person);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("conf/annotation-test.xml");
        // PersonDao personDao = applicationContext.getBean("personDao", PersonDao.class);
        // PersonDao personDao1 = applicationContext.getBean("personDao", PersonDao.class);
        // System.out.println(personDao == personDao1);
        PersonServlet personServlet = applicationContext.getBean(PersonServlet.class);
        personServlet.save();

    }
}
