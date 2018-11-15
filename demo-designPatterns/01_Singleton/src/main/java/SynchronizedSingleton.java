/**
 * Created by sheng on 2018/6/20.
 */
public class SynchronizedSingleton {

    private volatile static SynchronizedSingleton singleton;

    private SynchronizedSingleton() {

    }

    /**
     * 双重加锁机制
     * 高并发时也会有问题，原因：
     * JVM创建新的对象时分为3步：
        1.分配内存
        2.初始化构造器
        3.将对象指向分配的内存的地址
        2、3可能相反（字节码调优）
        如果在初始化构造器之前使用了singleton就会出错
     * @return
     */
    public static SynchronizedSingleton getInstance() {
        if (singleton == null) {
            synchronized (SynchronizedSingleton.class) {
                if (singleton == null) {
                    singleton = new SynchronizedSingleton();
                }
            }
        }
        return singleton;
    }
}
