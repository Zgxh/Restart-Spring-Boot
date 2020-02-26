package com.zgxh.springboot.service.implementation;

import com.zgxh.springboot.mapper.UserMapper;
import com.zgxh.springboot.model.User;
import com.zgxh.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yu Yang
 * @create 2020-02-19 19:01
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userMapper.selectAllUsers();
    }
}
