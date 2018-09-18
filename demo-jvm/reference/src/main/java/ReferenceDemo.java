import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 强引用：通过new得到的内存空间的引用叫强引用
 * 软引用：如果一个对象只有软引用，当虚拟机内存堆内存足够，则垃圾回收不会回收它，否则回收这些软引用的对象
 * 弱引用：垃圾回收器发现某块内存只有弱引用，不管当前内存空间是否足够，都会去回收
 * 虚引用：
 * Created by sheng on 2018/9/18.
 */
public class ReferenceDemo {

    public static void main(String[] args) {
        // 强引用
        String str = new String("abc");
        // 软引用
        SoftReference<String> softRef = new SoftReference<String>(str);
        // 去掉强引用
        str = null;
        System.gc();    // 垃圾回收器回收
        System.out.println(softRef.get());

        // 强引用
        String abc = new String("123");
        // 弱引用
        WeakReference<String> weakRef = new WeakReference<String>(abc);
        abc = null;
        System.gc();
        System.out.println(weakRef.get());
    }
}