
import com.zgxh.service.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Yu Yang
 * @create 2020-06-10 19:52
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AOPTest {

    /*
    当有切面时，从容器中拿目标要用接口类型，因为容器中的组件是代理对象com.sun.proxy.$Proxy16，
    不是本类对象，但代理对象和本类对象有同样的接口；
    当没有切面的时候，就不会创建代理对象。
    */

    @Autowired
    Calculator calculator;

    @Test
    public void test() {
        calculator.add(1, 1);
        System.out.println(calculator.getClass());
    }
}
