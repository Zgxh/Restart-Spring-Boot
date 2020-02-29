package com.zgxh.springboot.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.zgxh.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Yu Yang
 * @create 2020-02-29 19:22
 */
@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // 把查询结果集映射成User对象
    static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getInt("age"));
            user.setAddress(resultSet.getString("address"));
            user.setTel(resultSet.getString("tel"));
            return user;
        }
    }

    // 查询总数
    public int getUserNum() {
        return jdbcTemplate.queryForObject("select count(*) from 303member", Integer.class);
    }

    // 按id查询单个User,使用queryForObject()
    public User selectUserById(Integer id) {
        String sql = "select * from 303member where id=?";
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
    }

    // 查询全部，返回列表，使用query()
    public List<User> selectAllUsers() {
        String sql = "select * from 303member";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    // 添加用户,并返回当前人数
    public int insertUser(final User user) {
        String sql = "insert into 303member values (?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getId(), user.getName(), user.getAge(), user.getAddress(), user.getTel());
        return getUserNum();
    }
}
