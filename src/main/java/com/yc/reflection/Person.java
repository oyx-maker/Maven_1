package com.yc.reflection;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Maven_1
 * @description: wu
 * @author: oyx
 * @create: 2021-03-29 19:08
 */
public class Person implements Showable{
    private String name;
    private int age;
    public Person()
    {
        System.out.println("无参构造方法");
    }
    public Person(String name)
    {
        this.name=name;
        System.out.println("有参构造方法");
        Date d=new Date();
        d.getYear();

        Map map=new HashMap();
       // @SuppressWarnings()//抑制警告信息



    }
    @Override
    public void show() {
        System.out.println(" show");
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
}
