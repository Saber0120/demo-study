package chapter05;

/**
 * Created by Administrator on 2018/7/20.
 */
public class TestPersonDemo3_2 {

    public static void main(String[] args) {
        Person2 p = new Person2();
        p.setName("张三");
        p.setAge(-25);
        p.talk();
    }
}

class Person2 {

    private String name;
    private int age;

    public void talk() {
        System.out.println("我叫 " + name + ", 今年 "  + age + " 岁了");
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