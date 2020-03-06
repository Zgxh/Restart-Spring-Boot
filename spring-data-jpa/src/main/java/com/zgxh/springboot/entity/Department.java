package com.zgxh.springboot.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 部门实体
 *
 * @author Yu Yang
 * @create 2020-03-05 20:31
 */
@Entity
public class Department {

    // 主键, departmenId
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 名字
    @Column
    private String name;

    @OneToMany(mappedBy = "department") // 对应user类的department
    private Set<User> users = new HashSet<>();

    /**
     * 空构造器
     */
    public Department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
