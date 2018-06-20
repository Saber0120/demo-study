package factory;

/**
 * Created by sheng on 2018/6/20.
 */
public class FactoryB implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
