package easyfactory;

/**
 * Created by sheng on 2018/6/20.
 */
public class Factory {

    public static Product createProduct(String type) {
        if ("A".equals(type)) {
            return new ProductA();
        } else if ("B".equals(type)) {
            return new ProductB();
        } else {
            return null;
        }
    }
}
