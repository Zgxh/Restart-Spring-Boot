package com.zgxh.springboot.mapper;

import com.zgxh.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(User record);

    int insertSelective(User record);

    List<User> selectAllUsers();

    User selectById(Integer id);
}