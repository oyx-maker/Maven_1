package com.yc.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: Maven_1
 * @description: wu
 * @author: oyx
 * @create: 2021-03-29 18:44
 */
public class test1 {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        while (true)
        {
            System.out.println("请输入类路径：");
            String path=sc.nextLine();
            System.out.println("待加载的类为:"+path);
            Class c=Class.forName(path);
            String name=c.getName();
            System.out.println(name);
            //返回的数组 Field对象反映此表示的类或接口声明的所有字段 类对象。
            Field[] fs=c.getDeclaredFields();
            if (fs!=null && fs.length>0)
            {
                String modifer="";
                for (Field f:fs)
                {
                    switch (f.getModifiers()) {
                        case 1:
                            modifer = "public";
                            break;
                        case 2:
                            modifer = "private";
                            break;
                    }
                    System.out.println(f.getModifiers()+"\t"+f.getName());
                }
            }
            //返回包含一个数组 方法对象反射的类或接口的所有声明的方法，
            // m,通过此表示 类对象，包括公共，保护，默认（包）访问和私有方法，但不包括继承的方法。
            Method[] ms=c.getDeclaredMethods();
            if (ms!=null && ms.length>0)
            {
                String modifer="";
                for (Method m:ms)
                {

                    System.out.println(m.getModifiers()+"\t"+m.getReturnType().toString()+"\t"+m.getName());
                }
            }

            //构造器
            Constructor[] cs=c.getConstructors();
            if (cs!=null && cs.length>0)
            {
                for (Constructor css:cs)
                {

                    System.out.println(css.getModifiers()+"\t"+css.getName());
                }
            }
            //利用反射 完成实例化
            Object o=c.newInstance();//无参构造方法
            if (o instanceof Showable)
            {
                Showable p=(Showable)o;
                p.show();
            }
            //利用反射 调用某个方法
            if (ms!=null && ms.length>0)
            {
                for (Method m:ms)
                {
                    if (m.getName().startsWith("sh"))
                    {
                        m.invoke(o);
                    }
                    //System.out.println(m.getModifiers()+"\t"+m.getReturnType().toString()+"\t"+m.getName());
                }
            }
            Map<String ,String> pMap=new HashMap<String ,String>();
            pMap.put("name","张三");
            pMap.put("age",30+"");

            Object oo=setValues(pMap,c);
            System.out.println(oo.toString());

        }
    }


    /*
    反射功能模块：将Map中保存的 属性值 存到 cls对应的对象中
     */
    public static Object setValues (Map<String,String> map, Class cls) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object o=null;
        o=cls.newInstance();
        Method[] ms=cls.getDeclaredMethods();
        if (ms!=null && ms.length>0)
        {
            for (Method m:ms)
            {
                if (m.getName().startsWith("set"))
                {
                    String name=m.getName();
                    String fname=name.substring(3).toLowerCase();
                    String value= map.get(fname);
                    if ( "Integer".equalsIgnoreCase(m.getParameterTypes()[0].getName()) ||  "Int".equalsIgnoreCase(m.getParameterTypes()[0].getName()))
                    {
                        m.invoke(o,Integer.parseInt(value));
                    }else
                       { m.invoke(o,value);}

                }

            }
        }
        return o;
    }
}
