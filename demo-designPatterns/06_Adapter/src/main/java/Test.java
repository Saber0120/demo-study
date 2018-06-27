import java.util.HashMap;
import java.util.Map;

/**
 * Created by sheng on 2018/6/27.
 */
public class Test {

    public static void main(String[] args) {
        User user = new User();
        HashMapObserverAdapter map = new HashMapObserverAdapter();
        map.put("123", "456");
        System.out.println(map.get("123"));
        user.addObserver(map);
        user.setChanged();
        user.notifyObservers();
        System.out.println(map.get("123"));
    }
}
