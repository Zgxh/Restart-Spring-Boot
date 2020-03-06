package com.zgxh.springboot.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户实体
 *
 * @author Yu Yang
 * @create 2020-03-05 20:27
 */
@Entity
public class User {

    // 主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长主键
    private Integer id;

    // 名称
    @Column
    private String name;

    // 创建时间
    @Column(name = "create_time")
    private Date createTime;

    // 部门ID
    @ManyToOne // 多对一
    @JoinColumn(name = "department_id")
    private Department department;

    /**
     * jpa要求的空构造器
     */
    public User() {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
