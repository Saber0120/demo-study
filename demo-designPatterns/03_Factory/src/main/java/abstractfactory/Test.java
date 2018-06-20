package abstractfactory;

/**
 * Created by sheng on 2018/6/20.
 */
public class Test {

    public static void main(String[] args) {
        ProductFactory fa = new FactoryA();
        Product pa = fa.createProduct();
        Product1 p1a = fa.createProduct1();

        ProductFactory fb = new FactoryB();
        Product pb = fb.createProduct();
        Product1 p1b = fb.createProduct1();

        pa.method();
        p1a.method();
        pb.method();
        p1b.method();
    }
}
