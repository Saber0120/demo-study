package chapter05;

/**
 * 下面这个范例说明了使用 Person 类的对象调用类中的属性与方法的过程
 * Created by Administrator on 2018/7/20.
 */
public class TestPersonDemo {

    public static void main(String[] args) {
        //  当执行到Person person时，只是在栈内存中声明了一个person对象，还没有开辟内存空间
        //  new关键字就是开辟内存空间，把堆内存的引用赋值给了person，这时候才实例化了一个对象
        Person person = new Person();
        person.name = "张三";
        person.age = 28;
        person.talk();
    }
}
