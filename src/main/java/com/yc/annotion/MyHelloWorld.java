package com.yc.annotion;

import java.lang.annotation.*;
//{   }->数组
//Target->元注解 即注解的注解

@Target(value={ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})


@Retention(value = RetentionPolicy.RUNTIME)
@Documented  //生成的java doc文档中是否保留这个注解
@Inherited     //子类是否可以继承父类的注解

public @interface MyHelloWorld {
    public  String name();
    public int age () default 20;//带默认值
    public String [] ins();


}
