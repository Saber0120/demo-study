package chapter05;

/**
 * 对象数组的使用
 * Created by sheng on 2018/7/23.
 */
public class TestObjectArray {

    public static void main(String[] args) {
        Person[] persons = {new Person("张三", 25), new Person("李四", 26), new Person("王五", 27)};

        for (int i = 0; i < persons.length; i++) {
            persons[i].talk();
        }
    }
}
