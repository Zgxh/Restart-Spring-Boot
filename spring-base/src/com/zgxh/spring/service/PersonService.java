package com.zgxh.spring.service;

import com.zgxh.spring.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yu Yang
 * @create 2020-06-06 16:19
 */
@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public void save() {
        System.out.println("PersonService 调用 PersonDao 进行 save ...");
        personDao.save();
    }
}
