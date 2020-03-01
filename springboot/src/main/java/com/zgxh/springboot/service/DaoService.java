package com.zgxh.springboot.service;


import com.zgxh.springboot.model.User;

import java.util.List;

/**
 * @author Yu Yang
 * @create 2020-02-29 19:39
 */
public interface DaoService {

    int getUserNum();

    User selectUserById(Integer id);

    List<User> selectAllUsers();

    int insertUser(User user);

    User updateUser(User user);
}
