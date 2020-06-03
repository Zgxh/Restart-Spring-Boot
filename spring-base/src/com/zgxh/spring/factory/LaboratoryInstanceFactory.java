package com.zgxh.spring.factory;

import com.zgxh.spring.bean.Laboratory;

/**
 * 实例工厂类
 *
 * @author Yu Yang
 * @create 2020-06-03 14:39
 */
public class LaboratoryInstanceFactory {

    public Laboratory getLaboratory(String labName) {
        Laboratory laboratory = new Laboratory();
        laboratory.setLabName(labName);
        System.out.println("实例工厂正在创建对象...");
        return laboratory;
    }
}
