import com.service.ConvertService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class test {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
    }

    /**
     * 数字0到9转换为字母
     */
    @Test
    public void convertFir(){
        ConvertService demoService = (ConvertService)applicationContext.getBean("ConvertService");
        String demo1 = demoService.getConvertFir(new int[]{2,3});
        System.out.println(demo1);
    }

    /**
     * 数字0到99转换为字母
     */
    @Test
    public void convertSec(){
        ConvertService demoService = (ConvertService)applicationContext.getBean("ConvertService");
        String demo2 = demoService.getConvertSec(new int[]{21,30,99});
        System.out.println(demo2);
    }

}
