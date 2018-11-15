import java.lang.ref.WeakReference;
import java.util.*;

/**
 * Created by sheng on 2018/9/18.
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
//        String a = new String("a");
//        String b = new String("b");
//        Map<String, String> weakMap = new WeakHashMap<>();
//        Map<String, String> map = new HashMap<>();
//        map.put(a, "aaa");
//        map.put(b, "bbb");
//        weakMap.put(a, "aaa");
//        weakMap.put(b, "bbb");
//        map.remove(a);
//        a = null;
//        b = null;
//        System.gc();
//        Iterator<Map.Entry<String, String>> i = map.entrySet().iterator();
//        if (i.hasNext()) {
//            Map.Entry<String, String> entry = i.next();
//            System.out.println("map = " + entry.getKey() + ":" + entry.getValue());
//        }
//        Iterator<Map.Entry<String, String>> j = weakMap.entrySet().iterator();
//        if (j.hasNext()) {
//            Map.Entry<String, String> entry = j.next();
//            System.out.println("weakMap = " + entry.getKey() + ":" + entry.getValue());
//            // a对应内存上的强引用已经全部被移除，只剩弱引用，弱引用在垃圾回收后被移除
//        }

        test2();
//        testCase4();
    }

    public static void test() {
        Map<Coupan, WeakReference<List<User>>> map = new WeakHashMap();
        List<Coupan> coupanList = new ArrayList<>();
        Coupan coupan1 = new Coupan("优惠券1");
        Coupan coupan2 = new Coupan("优惠券2");
        coupanList.add(coupan1);
        coupanList.add(coupan2);
        List<User> userList1 = new ArrayList<>();
        List<User> userList2 = new ArrayList<>();
        User user1 = new User("用户1");
        User user2 = new User("用户2");
        User user3 = new User("用户3");
        User user4 = new User("用户4");
        User user5 = new User("用户5");
        userList1.add(user1);
        userList1.add(user2);
        userList1.add(user3);
        userList2.add(user3);
        userList2.add(user4);
        userList2.add(user5);
        WeakReference<List<User>> weakRef1 = new WeakReference(userList1);
        WeakReference<List<User>> weakRef2 = new WeakReference(userList2);
        map.put(coupan1, weakRef1);
        map.put(coupan2, weakRef2);
        System.out.println("1.map.get(coupan1).size()---" + map.get(coupan1).get().size());
        System.out.println("2.map.get(coupan2).size()---" + map.get(coupan2).get().size());
        System.out.println("user1 remove");
        userList1.remove(user1);
        System.out.println("3.map.get(coupan1).size()---" + map.get(coupan1).get().size());
        System.out.println("4.map.get(coupan2).size()---" + map.get(coupan2).get().size());
        System.out.println("user3 remove");
        userList2.remove(user3);
        System.out.println("5.map.get(coupan1).size()---" + map.get(coupan1).get().size());
        System.out.println("6.map.get(coupan2).size()---" + map.get(coupan2).get().size());

        System.out.println("7.map.size():" + map.size());
        System.out.println("coupan1 remove");
        coupanList.remove(coupan1);
        coupan1 = null;
//        System.gc();
        System.out.println("8.map.size():" + map.size());
    }

    public static void test2() {
        Map<Coupan, List<WeakReference<User>>> map = new WeakHashMap();
        List<Coupan> coupanList = new ArrayList<>();
        Coupan coupan1 = new Coupan("优惠券1");
        Coupan coupan2 = new Coupan("优惠券2");
        coupanList.add(coupan1);
        coupanList.add(coupan2);
        List<User> userList = new ArrayList<>();
        User user1 = new User("用户1");
        User user2 = new User("用户2");
        User user3 = new User("用户3");
        User user4 = new User("用户4");
        User user5 = new User("用户5");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        List<WeakReference<User>> weakRef1 = new ArrayList<>();
        weakRef1.add(new WeakReference<User>(user1));
        weakRef1.add(new WeakReference<User>(user2));
        weakRef1.add(new WeakReference<User>(user3));
        List<WeakReference<User>> weakRef2 = new ArrayList<>();
        weakRef2.add(new WeakReference<User>(user1));
        weakRef2.add(new WeakReference<User>(user4));
        weakRef2.add(new WeakReference<User>(user5));
        map.put(coupan1, weakRef1);
        map.put(coupan2, weakRef1);

        System.out.println("1.map.get(coupan1).size()---" + map.get(coupan1).size());
        System.out.println("2.map.get(coupan2).size()---" + map.get(coupan2).size());
        System.out.println("user1 remove");
        userList.remove(user1);
        user1 = null;
        System.gc();

        System.out.println("3.map.get(coupan1).size()---" + map.get(coupan1).size());
        System.out.println("4.map.get(coupan2).size()---" + map.get(coupan2).size());
        for (WeakReference<User> userWeakReference : map.get(coupan1)) {
            System.out.println(userWeakReference.get());
        }

        for (WeakReference<User> userWeakReference : map.get(coupan1)) {
            System.out.println(userWeakReference.get());
        }
    }

    public static void testCase4() {
        User demo1 = new User("hello world");
        WeakReference<User> sr = new WeakReference<User>(demo1);

        List<WeakReference> lists = new ArrayList<>();
        lists.add(sr);
        demo1 = null;

        System.gc();
        System.out.println(lists.size());
        System.out.println(sr.get());
    }
}

class Coupan {

    String coupanName;

    public Coupan(String coupanName) {
        this.coupanName = coupanName;
    }
}

class User {

    String name;

    public User(String name) {
        this.name = name;
    }
}