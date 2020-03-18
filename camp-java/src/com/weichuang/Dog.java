package com.weichuang;

/**
 * 遵守java封装性的类
 * 成员与方法组成
 * 封装：属性私有化，对外暴露接口，进行属性的访问
 */
public class Dog {
    //成员属性  是有默认值的，引用类型的默认值就是null
    private String name;
    private int age;

    /**
     * 默认的无参构造器/构造方法
     * 构造方法没有返回类型，void空也不许写
     * 方法名要与类名相同
     *
     *  下面两个构造方法直接称为，构造方法的重载
     */
    public Dog(){

    }
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
