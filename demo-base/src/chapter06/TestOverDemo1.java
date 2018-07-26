package chapter06;

/**
 * 复写
 * 方法：子类与父类中的方法名、参数个数、类型完全一致时，称为子类复写了父类中的方法。
 * 属性：同理，子类定义与父类中已有的属性时，则复写了父类的属性。
 * Created by sheng on 2018/7/26.
 */
public class TestOverDemo1 {

    public static void main(String[] args) {
        Student4 s = new Student4("张三", 23, "南师大");
        s.talk();
    }
}

class Person4 {

    String name;

    int age;

    public void talk() {
        System.out.println("我叫：" + this.name + "，年龄：" + this.age);
    }
}

class Student4 extends Person4 {

    String school;

    public Student4(String name, int age, String school) {
        super.name = name;
        super.age = age;
        this.school = school;
    }

    // 被复写的方法不能拥有比父类更严格的访问权限，这里不能为private或protected或空
    public void talk() {
        System.out.println("我在 " + school + " 上学！");
    }
}