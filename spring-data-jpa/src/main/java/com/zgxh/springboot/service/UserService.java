package com.zgxh.springboot.service;

import com.zgxh.springboot.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 服务
 *
 * @author Yu Yang
 * @create 2020-03-06 13:55
 */
public interface UserService {

    /**
     * 按id查用户
     * @param id 主键
     * @return 用户信息User
     */
    User findUserById(Integer id);

    /**
     * 按 name 和 departmentId 查询用户
     * @param name 名称
     * @param departmentId 部门 id
     * @return 用户信息 User
     */
    User findUser(String name, Integer departmentId);

    /**
     * 新增用户
     * @param user 新增用户信息
     * @return 影响的行数
     */
    Integer addUser(User user);

    /**
     * 分页查询
     * @param page 开始
     * @param size 结束
     * @return 用户 list
     */
    List<User> getAllUser(int page, int size);

    /**
     * 分页查询某个部门的用户
     * @param departmentId 部门 id
     * @param page 分页参数
     * @return 用户 page
     */
    Page<User> queryUser(Integer departmentId, Pageable page);

    /**
     * 按example例子查询用户
     * @param name 名称
     * @return user list
     */
    List<User> getUserByExample(String name);

    /**
     * 修改用户信息
     */
    void updateUser();
}
