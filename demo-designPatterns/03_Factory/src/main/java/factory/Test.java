package factory;

/**
 * Created by sheng on 2018/6/20.
 */
public class Test {

    public static void main(String[] args) {
        ProductFactory fa = new FactoryA();
        Product a = fa.createProduct();
        a.method();

        ProductFactory fb = new FactoryB();
        Product b = fb.createProduct();
        b.method();
    }
}
