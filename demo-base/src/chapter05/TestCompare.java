package chapter05;

/**
 * 判断两个对象是否相等
 * Created by Administrator on 2018/7/21.
 */
public class TestCompare {

    public static void main(String[] args) {
        Person p1 = new Person("张三", 22);
        Person p2 = new Person("张三", 22);
        System.out.println(p1.compare(p2) ? "是同一个人！" : "不是同一个人！");;
    }
}
