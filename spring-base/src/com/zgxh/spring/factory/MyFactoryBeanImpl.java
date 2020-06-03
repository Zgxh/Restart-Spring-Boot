package com.zgxh.spring.factory;

import com.zgxh.spring.bean.Laboratory;
import org.springframework.beans.factory.FactoryBean;

/**
 * 通过实现FactoryBean接口来创建一个spring认识的工厂类；
 * 然后spring会自动调用工厂类方法来创建Bean实例
 *
 * @author Yu Yang
 * @create 2020-06-03 14:25
 */
public class MyFactoryBeanImpl implements FactoryBean<Laboratory> {

    @Override
    public Laboratory getObject() throws Exception {
        Laboratory laboratory = new Laboratory();
        laboratory.setLabName("305");
        System.out.println("使用FactoryBean来创建对象...");
        return laboratory;
    }

    @Override
    public Class<?> getObjectType() {
        return Laboratory.class;
    }

    /**
     * 控制返回的对象是不是单例对象
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
