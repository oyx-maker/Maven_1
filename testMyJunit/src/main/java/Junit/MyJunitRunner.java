package Junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Maven_1
 * @description: wu
 * @author: oyx
 * @create: 2021-03-31 19:48
 */
public class MyJunitRunner {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //因为没有idea插件  只能先做  class加载
        Class cls=Class.forName("com.yc.MyCaculateTest");

        //TODO:升级：按照maven约定的目录要求来扫描test/java下的单元测试类
        //获取这个类中所有的方法
        Method[] ms=cls.getDeclaredMethods();
        List<Method> testMethods=new ArrayList<Method>();
        Method beforeMethod=null;
        Method afterMethod=null;
        Method beforeClassMethod=null;
        Method afterClassMethod=null;


        if (ms!=null && ms.length>0)
        {
            String modifer="";
            //循环这些方法  判断上面加了哪个备注
            for (Method m:ms)
            {
                //将这些方法分别保存好  @Test对应的方法有多个  存到一个集合  其他注解对应的方法只有一个  直接存
                if (m.isAnnotationPresent(MyTest.class))
                {
                    testMethods.add(m);
                }
                if (m.isAnnotationPresent(MyBefore.class))
                {
                    beforeMethod=m;
                }
                if (m.isAnnotationPresent(MyAfter.class))
                {
                    afterMethod=m;
                }if (m.isAnnotationPresent(BeforeClass.class))
                {
                beforeClassMethod=m;
                }if (m.isAnnotationPresent(AfterClass.class))
                {
                afterClassMethod=m;
                }




            }
        }

    //按junit的运行的生命周期来调用
        if (testMethods==null || testMethods.size()<=0)
        {
            throw new RuntimeException("没有测试的方法");
        }
        Object o=cls.newInstance();//实例化  测试类
        beforeClassMethod.invoke(o,null);//@BeforeClass
        for (Method m:testMethods)
        {
            if (beforeMethod!=null)
            {
                beforeMethod.invoke(o,null);//@Before
            }
            m.invoke(o,null);//测试方法
            if (afterMethod!=null)
            {
                afterMethod.invoke(o,null);//@After
            }
        }
        afterClassMethod.invoke(o,null);//@AfterClass
    }
}
