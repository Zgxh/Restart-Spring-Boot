package com.zgxh.springboot.service;

import com.zgxh.springboot.model.User;

import java.util.List;

/**
 * @author Yu Yang
 * @create 2020-02-19 18:59
 */
public interface UserService {

    public List<User> selectAllUsers();

    public User selectById(Integer id);
}
