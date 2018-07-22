package chapter05;

/**
 * 匿名对象
 * Created by Administrator on 2018/7/21.
 */
public class TestNoName {

    public static void main(String[] args) {
        //  没有任何一个具体的对象名称引用它
        new Person("张三", 25).talk();    //  之后就会被 Java 的垃圾收集器回收
    }
}
