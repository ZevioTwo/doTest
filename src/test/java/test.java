import org.junit.jupiter.api.Test;

public class test {

    @Test
    public void test(){
        String demo1 = Demo.change(new int[]{2,3});
        System.out.println(demo1);
        String demo2 = Demo2.change(new int[]{21,30,99});
        System.out.println(demo2);
    }
}
