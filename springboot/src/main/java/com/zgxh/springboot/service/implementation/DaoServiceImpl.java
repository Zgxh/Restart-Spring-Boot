package com.zgxh.springboot.service.implementation;

import com.zgxh.springboot.dao.UserDao;
import com.zgxh.springboot.model.User;
import com.zgxh.springboot.service.DaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yu Yang
 * @create 2020-02-29 19:39
 */
@Service
public class DaoServiceImpl implements DaoService {

    @Autowired
    UserDao userDao;

    @Override
    public int getUserNum() {
        return userDao.getUserNum();
    }

    @Override
    public User selectUserById(Integer id) {
        return userDao.selectUserById(id);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public List<User> selectAllUsers() {
        return userDao.selectAllUsers();
    }
}
