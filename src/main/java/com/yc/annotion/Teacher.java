package com.yc.annotion;

/**
 * @program: Maven_1
 * @description: wu
 * @author: oyx
 * @create: 2021-03-29 20:34
 */
@MyHelloWorld(name = "a",age=30,ins="打球")
public class Teacher {
    @MyHelloWorld(name = "b",ins={"game","swim"})
    private String name;

    public String show(String s)
    {
        return "";
    }
}
