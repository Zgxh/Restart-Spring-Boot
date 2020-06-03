package com.zgxh.spring.bean;

import java.util.List;

/**
 * @author Yu Yang
 * @create 2020-06-03 13:59
 */
public class Laboratory {

    private String labName;
    private Integer personNum;
    private List<Person> persons;

    public Laboratory(String labName, Integer personNum, List<Person> persons) {
        this.labName = labName;
        this.personNum = personNum;
        this.persons = persons;
    }

    public Laboratory() {
        System.out.println("Laboratory 被加载...");
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Laboratory{" +
                "labName='" + labName + '\'' +
                ", personNum=" + personNum +
                ", persons=" + persons +
                '}';
    }
}