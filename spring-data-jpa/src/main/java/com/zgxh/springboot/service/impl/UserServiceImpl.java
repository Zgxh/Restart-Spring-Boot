package com.zgxh.springboot.service.impl;

import com.zgxh.springboot.entity.Department;
import com.zgxh.springboot.entity.User;
import com.zgxh.springboot.repository.UserRepository;
import com.zgxh.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户服务的实现
 *
 * @author Yu Yang
 * @create 2020-03-06 13:55
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public User findUser(String name, Integer departmentId) {
        return userRepository.findUser(name, departmentId);
    }

    @Override
    public Integer addUser(User user) {
        userRepository.save(user); // 保存user，如果信息中包含id，则认为是更新实体
        return user.getId();
    }

    @Override
    public List<User> getAllUser(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<User> pageObject = userRepository.findAll(pageable);
        int totalPage = pageObject.getTotalPages();
        int realSize = pageObject.getSize();
        long count = pageObject.getTotalElements();
        return pageObject.getContent();
    }

    @Override
    public Page<User> queryUser(Integer departmentId, Pageable page) {
        return userRepository.queryUser(departmentId, page);
    }

    @Override
    public List<User> getUserByExample(String name) {
        User user = new User();
        Department department = new Department();
        user.setName(name);
        department.setId(1);
        user.setDepartment(department);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name",
                ExampleMatcher.GenericPropertyMatchers.startsWith().ignoreCase());
        Example<User> example = Example.of(user, matcher);
        return userRepository.findAll(example);
    }

    @Override
    public void updateUser() {

    }
}
