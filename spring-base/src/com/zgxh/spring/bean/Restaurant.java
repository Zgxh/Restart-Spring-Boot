package com.zgxh.spring.bean;

/**
 * @author Yu Yang
 * @create 2020-06-03 17:31
 */
public class Restaurant {

    private String resName;
    private Person boss;

    public Restaurant() {
        System.out.println("Restaurant对象被创建...");
    }

    public Restaurant(String resName, Person boss) {
        this.resName = resName;
        this.boss = boss;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public Person getBoss() {
        return boss;
    }

    public void setBoss(Person boss) {
        this.boss = boss;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "resName='" + resName + '\'' +
                ", boss=" + boss +
                '}';
    }
}
