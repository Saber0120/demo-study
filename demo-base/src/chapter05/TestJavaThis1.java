package chapter05;

/**
 * 用 this 调用构造方法
 * this 调用构造方法必须也只能放在构造方法的第一行
 * Created by Administrator on 2018/7/21.
 */
public class TestJavaThis1 {

    public static void main(String[] args) {
        new Person("张三", 22).talk();
    }
}
