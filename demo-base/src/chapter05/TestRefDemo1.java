package chapter05;

/**
 * 引用数据类型的传递
 * Created by Administrator on 2018/7/20.
 */
public class TestRefDemo1 {

    public static void main(String[] args) {
        Person p1 = null;
        Person p2 = null;
        p1 = new Person();
        p1.name = "张三";
        p1.age = 30;

        p2 = p1;    //  将p1的引用赋值给p2，p1和p2指向同一块堆内存
        p2.talk();
        p1 = null;  //  断开p1与对象的引用，p2则继续指向原p1指向的引用
        //  如果  p2 = null;   则这个对象就成为了垃圾对象
    }
}
