import org.junit.Assert;
//测试用例类
public class CalculateTest {
private  Calculate cal;             //待测试的单元
    @org.junit.Before               //执行测试方法前调用
    public void setUp() throws Exception {
        System.out.println("before");
        cal=new Calculate();

    }

    @org.junit.After                  //执行测试方法后调用
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    @org.junit.Test
    public void add() {
        Assert.assertEquals(3,cal.add(1,2));

    }

    @org.junit.Test
    public void sub() {
        Assert.assertEquals(1,cal.sub(2,1));
    }
}