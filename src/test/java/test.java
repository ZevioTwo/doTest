import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import com.service.DemoService;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class test {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void test1(){
        DemoService demoService = (DemoService)applicationContext.getBean("DemoService");
        String demo1 = demoService.getTest1(new int[]{2,3});
        System.out.println(demo1);
    }

    @Test
    public void test2(){
        DemoService demoService = (DemoService)applicationContext.getBean("DemoService");
        String demo2 = demoService.getTest2(new int[]{21,30,99});
        System.out.println(demo2);
    }

}
