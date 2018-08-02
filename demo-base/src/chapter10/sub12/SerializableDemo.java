package chapter10.sub12;

import java.io.*;

/**
 * 对象序列化：
 * ObjectInputStream和ObjectOutputStream
 * 对象必须实现序列化
 * Created by sheng on 2018/8/2.
 */
public class SerializableDemo {

    public static void main(String[] args) {
        File file = new File("D:\\serializable.txt");
        serialize(file);
        deSerialize(file);
    }

    private static void deSerialize(File file) {
        try {
            InputStream input = new FileInputStream(file);
            ObjectInputStream oInput = new ObjectInputStream(input);
            Person p = (Person) oInput.readObject();
            System.out.println(p);  //  Person{name='张三', age=24, school='null'}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void serialize(File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            ObjectOutputStream count = new ObjectOutputStream(out);
            count.writeObject(new Person());
            count.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//  必须实现序列化接口
class Person implements Serializable {

    private static final long serialVersionUID = 1364305430722892123L;

    String name = "张三";

    int age = 24;

    //  被transient修饰的变量不会被序列化
    transient String school = "nuist";

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                '}';
    }
}