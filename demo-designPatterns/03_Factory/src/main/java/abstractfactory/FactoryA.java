package abstractfactory;

/**
 * Created by sheng on 2018/6/20.
 */
public class FactoryA implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }

    @Override
    public Product1 createProduct1() {
        return new Product1A();
    }
}
