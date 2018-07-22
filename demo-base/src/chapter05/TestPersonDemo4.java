package chapter05;

/**
 * 封装属性：private 属性类型 属性名称;
 * 封装方法：private 方法返回值类型 方法名
 * Created by Administrator on 2018/7/20.
 */
public class TestPersonDemo4 {
    public static void main(String[] args) {
        Person3 p = new Person3();
        p.setName("张三");
        p.setAge(-25);
        //  被private修饰的属性和方法无法被外部类调用
        //  p.talk();
    }
}

class Person3 {

    private String name;
    private int age;

    private void talk() {
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
