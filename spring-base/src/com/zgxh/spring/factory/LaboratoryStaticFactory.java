package com.zgxh.spring.factory;

import com.zgxh.spring.bean.Laboratory;

/**
 * 静态工厂类
 *
 * @author Yu Yang
 * @create 2020-06-03 14:41
 */
public class LaboratoryStaticFactory {

    public static Laboratory getLaboratory(String labName) {
        Laboratory laboratory = new Laboratory();
        laboratory.setLabName(labName);
        System.out.println("静态工厂正在创建对象...");
        return laboratory;
    }
}
