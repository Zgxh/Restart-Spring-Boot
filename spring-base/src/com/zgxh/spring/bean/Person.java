package com.zgxh.spring.bean;

/**
 * @author Yu Yang
 * @create 2020-06-03 13:59
 */
public class Person {

    private String name;
    private Integer age;
    private Long tel;

    public Person() {
        System.out.println("Person 被加载...");
    }

    public Person(String name, Integer age, Long tel) {
        this.name = name;
        this.age = age;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", tel=" + tel +
                '}';
    }
}