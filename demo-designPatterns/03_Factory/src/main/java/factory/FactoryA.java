package factory;

/**
 * Created by sheng on 2018/6/20.
 */
public class FactoryA implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
