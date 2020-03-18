package com.weichuang;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 三种注释：提示程序员代码模块功能性，创建的时间，创建人
 *
 * 此种方式通常放于类或方法上。标注：此类或者此方法的作用
 *
 * public : 修饰符 作用于 类、方法、属性等 表示它的可见性 public可见性最高，private可见性最低。
 * class : 关键字，标记一个标识符为一个类
 * QuickStart ： 标识符 ，是一个类的名字； 有自己的命名规范，首字母大写，之后的单词的首字母也要大写
 * {} ：作用域或代码块 ;其中编写方法与属性等等
 *
 * @author cc
 * @createTime 2020-03-17
 */
public class QuickStart {

    static int j = 10;

    String s = "adc";

    /**
     * 主函数或主方法，一个类中只允许存在一个
     * static : 表示静态的
     * main ： 方法名称；命名规范，同样遵循驼峰命名法，但是首字母小写。
     * String[] : 数组，字符串类型的数组
     * args ：标识符，表示一个形参
     * void ：返回值类型 ,空返回值
     * @param args
     */
    public static void main(String[] args) {
        /*
            通常注释多行代码的时候使用
            注释原因
         */
        /*System.out.println("test1111");
        System.out.println("test2222");*/
        //单行注释 , 忽略某一行代码时 。 System.out.println ：打印输出语句
        System.out.println("hello , world !!!");
        System.out.println(j);
        //System.out.println(i);
        //tesTFun();
    }

    /**
     * 变量：
     * 数据类型上面划分 ： 基本数据类型的变量（8种基本数据类型） ,引用数据类型的变量
     * boolean : 布尔型  true,false 默认是false
     * byte : 字节型     默认值是0  所占字节数量  1
     * short : 短整型    默认值 0                 2
     * int  ： 整型 （使用最频繁的数据类型）  0     4
     * long :  长整型                  0            8
     * char ： 字符型             '\u0000'        2
     * float ： 单精度浮点型          0.0F       4
     * double :  双精度浮点型         0.0D       8
     * String : 引用类型
     * 自定义的猫、狗类等
     * 声明的位置上划分：全局/成员 变量   ，  局部变量
     *
     *
     * 标识符有自己的要求：
     * 由字母、数字、下划线（_） 、$ 组成
     * 区分大小写。
     * 数字不能开头
     * 长度不限制
     * 不能与java中关键字或者保留字冲突(const 、goto)
     *
     * @Test : 单元测试的注解，可以独立运行
     */
    @Test
    public void testFn(){
        int i = 0 ;
        System.out.println(i);
        s = "123";
        System.out.println(s);
    }

    /**
     * 条件判断
     * if(条件表达式){}else if(){}else{}
     * switch(数据类型)case 4:{}break
     * 三目运算符 x ? y : z
     */
    @Test
    public void testFn1(){
        int a = 8;
        if(a == 10){
            System.out.println("a等于10 成立");
        }else if(a == 5){
            System.out.println("a等于5");
        } else{
            System.out.println("a不等10");
        }
        //int 、byte 、short 、String （jdk1.7）
        switch ("abc"){
            case "ab":
                System.out.println("你传递过来的是ab");
                break;
            case "abc":
                System.out.println("你传递的是adc");
                break;
            default:
                System.out.println("默认执行");
                break;
        }
        //三目原算符,使用，一个条件判断时推荐使用
        System.out.println(a == 10 ? "a是10" : a == 5 ? "a等于5" : "a不等于 10和5");
    }

    /**
     * 数组 ： 一组相同数据类型的数据
     * 静态初始化与动态初始化
     * 动态初始化 ，数组一定要给默认长度
     * 数组索引由0开始
     *
     * 循环：
     * for() do while while foreach()增强的for循环
     */
    @Test
    public void testFn2(){
        //动态初始化
        String[] arr = new String[3];
        arr[0] = "zhangsan";
        arr[1] = "lisi";
        arr[2] = "wangwu";
        //静态初始化 , 初始长度由我们存入的数据的数量决定
        String[] arr2 = {"lily" , "tom"};
        for(int i = 0 ; i < arr.length ; i ++){
            System.out.println(arr[i]);
        }
        //增强for循环,不关注数组的下标，只关心元素
        for(String s : arr2){
            if("lily".equals(s)){
                System.out.println("这是lily");
            }else{
                System.out.println(s);
            }

        }
        System.out.println("----------------------------------");
        Dog[] dogs = new Dog[2];
        //使用new这个关键字实例化了dog这个类，就可以产生一个对象
        dogs[0] = new Dog("小花",3);
        dogs[1] = new Dog();
        for (Dog dog : dogs){
            System.out.println(dog);
        }
    }

    /**
     * 方法的重载
     * 在一个类中可以创建多个方法，若有几个方法的名字完全相同 ,但是方法的参数不同
     * 参数数量可以，参数类型不同可以，返回值类型不行
     */
    @Test
    public void testFn3(){
        //方法的返回值，我们可以接受，也可以不接受
        Dog dog = getDogByCondition(1);
        dog.setAge(10);
        System.out.println(dog.getAge());
        //System.out.println(dog.getName());
    }

    /*public String getDogByCondition(int id){
        return null;
    }*/
    public Dog getDogByCondition(int id){
        System.out.println(id);
        //new可以实例化出来一个对象，有内存空间
        return new Dog();
    }
    public Dog getDogByCondition(int id , String name){
        return null;
    }

    /**
     * 继承：
     * 是从已有的类创建新类的过程,并继承其内部的非私有的属性和方法
     * extends: 关键字，前面的类为子类，后面的类为父类
     * 1、java中只允许单继承
     * 2、多层继承
     * 3、只能继承非私有的属性和方法
     * 4、构造方法不能被继承
     */
    @Test
    public void testFn4(){
        Order o = new Order();
        System.out.println(o.name2);
        o.move();
    }

    /**
     * 接口
     * 表示一组行为（方法）规范
     * 接口中定义的方法，没有具体实现，需要实现类重写它的方法
     * 接口支持多实现。
     *
     * 多态：
     *
     */
    @Test
    public void testFn5(){
        Bird maque = new Yingwu();//多态的自动向上转型
        //只要代码块中出现异常，终止代码的执行
        //Maque maque1 = (Maque) new Bird(); //多态的向下转型（强制类型转换）
        //instanceof : 前面的数据类型与后面的是否一致
        if(maque instanceof Maque){
            Maque maque2 = (Maque)maque;
        }else{
            System.out.println("不是麻雀类型");
        }
    }
    /**
     * 集合：
     * List 、 ArrayList
     */
    @Test
    public void testFn6(){
        //默认的初始化长度为10
        //泛型: 我们事先定义好的类型,约束
        List<User> list = new ArrayList();
        //list.add("dsjhdjs");
        list.add(new User());
        //list.add(10);
        for (int i = 0 ; i < list.size() ; i ++){
            System.out.println(list.get(i));
        }
    }

}

class User extends Bird implements UserService,OrderService{
    public String name = "zhangsan";
    public void move(){
        System.out.println("我在走路");
    }

    @Override
    public void add(User user) {
        System.out.println("添加用户");
    }

    @Override
    public void update(User user) {
        System.out.println("更新用户");
    }

    @Override
    public Order getOrderById(int id) {
        return null;
    }
}
class Bird{
    public String name2 = "小鸟";
}
class Maque extends Bird{

}
class Yingwu extends Bird{

}

class Order extends User{

    //方法的重写   @Override会标识一下此方法为重写的
    @Override
    public void move() {
        System.out.println("我是订单，我也想走...");
    }
}
interface UserService{
    public abstract void add(User user);
    void update(User user);
    //default void defaultFn(){};
}
interface OrderService{
    Order getOrderById(int id);
}
