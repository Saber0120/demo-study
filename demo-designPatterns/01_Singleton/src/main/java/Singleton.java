/**
 * Created by sheng on 2018/6/20.
 */
public class Singleton {

    private static Singleton singleton;

    private Singleton() {

    }

    /**
     * 在高并发时并不是线程安全的
     * @return
     */
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
