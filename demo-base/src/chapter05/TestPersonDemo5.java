package chapter05;

/**
 * 在类内部调用方法
 * Created by Administrator on 2018/7/20.
 */
public class TestPersonDemo5 {

    public static void main(String[] args) {
        Person4 p = new Person4();
        p.setName("李四");
        p.setAge(30);
        p.say();
    }
}

class Person4 {

    private String name;
    private int age;

    private void talk() {
        System.out.println("我叫 " + name + ", 今年 "  + age + " 岁了");
    }

    //  新增了一个公共方法，调用私有方法talk()，供外部方法调用
    public void say() {
        this.talk();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0)
            this.age = age;
    }
}
