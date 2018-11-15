import org.junit.Test;

/**
 * Created by sheng on 2018/10/17.
 */
public class EnumSingletonTest {

    @Test
    public void testEnum() {
        EnumSingleton e1 = EnumSingleton.uniqueInstance;
        EnumSingleton e2 = EnumSingleton.uniqueInstance;
        EnumSingleton e3 = EnumSingleton.secondInstance;
        e1.singletonOperation();
        e2.singletonOperation();
        e3.singletonOperation();

        System.out.println(e1 == e2);
        System.out.println(e1 == e3);
    }
}
