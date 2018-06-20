package easyfactory;

/**
 * Created by sheng on 2018/6/20.
 */
public class Test {

    public static void main(String[] args) {
        Product a = Factory.createProduct("A");
        a.method();

        Product b = Factory.createProduct("B");
        b.method();
    }
}
