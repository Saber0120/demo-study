package abstractfactory;

/**
 * Created by sheng on 2018/6/20.
 */
public class FactoryB implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }

    @Override
    public Product1 createProduct1() {
        return new Product1B();
    }
}
