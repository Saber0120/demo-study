package chapter05;

/**
 * Title: PersonJavaDoc<br>
 * Description: 通过 PersonJavaDoc 类来说明 Java 中的文档注释<br>
 * Copyright:(c) 2004 www.sun.com.cn<br>
 * Company : sun java <br>
 *
 * @author lixinghua
 * @version 1.00
 */
public class PersonJavaDoc {

    private String name = "Careers";
    private String sex = "male";
    private int age = 30;

    /**
     * 这是 PersonJavaDoc 对象无参数的构造方法
     */
    public PersonJavaDoc() {
    }

    /**
     * 这是 PersonJavaDoc 类的有参构造方法
     *
     * @param name PersonJavaDoc 的名字
     * @param sex  PersonJavaDoc 的性别
     * @param age  PersonJavaDoc 的年龄
     */
    public PersonJavaDoc(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    /**
     * 这是设置 name 的值的方法，将参数 name 的值赋给变量 this.name
     *
     * @param name PersonJavaDoc 的名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 这是取得 name 的值的方法
     *
     * @return name 的值
     */
    public String getName() {
        return name;
    }

    /**
     * 这是取得 age 的值的方法
     *
     * @return age 的值
     */
    public int getAge() {
        return age;
    }

    /**
     * 这是设置 sex 的值的方法，将参数 sex 的值赋给变量 this.sex
     *
     * @param sex PersonJavaDoc 的性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 这是取得 sex 的值的方法
     *
     * @return sex 的值
     */
    public String getSex() {
        return sex;
    }

    /**
     * 这是设置 age 的值的方法
     *
     * @param age PersonJavaDoc 的年龄
     */
    public void setAge(int age) {
        if (age < 0)
            this.age = 0;
        else
            this.age = age;
    }

    public void shout() {
        System.out.println("我是 " + name + "，我性别 " + sex + "，今年 " + age + " 岁！");
    }
}
