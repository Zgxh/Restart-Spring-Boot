package com.zgxh.springboot.repository;

import com.zgxh.springboot.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 持久化Entity
 *
 * @author Yu Yang
 * @create 2020-03-06 14:14
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 按id查询用户，jpa自动转化为JPQL,是jpaRepository自带的方法
     * @param id 名字
     * @return User信息
     */
    User getOne(Integer id);

    /**
     * 按name和depId查询用户，利用@Query和JPQL语句(或SQL语句)进行查询
     * @param name
     * @param departmentId
     * @return
     */
    @Query("select u from User u where u.name=?1 and u.department.id=?2")
    // @Query("select * from user where name=?1 and department_id=?2")
    User findUser(String name, Integer departmentId);

    @Query("select u from User u where u.department.id=?1")
    Page<User> queryUser(Integer departmentId, Pageable page);
}
