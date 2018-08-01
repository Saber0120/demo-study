package chapter10.sub02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile类操作文件，可以跳转到文件的任意位置开始操作文件
 * Created by sheng on 2018/8/1.
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) {
        Employee e1 = new Employee("zhangsan", 20);
        Employee e2 = new Employee("lisi", 21);
        Employee e3 = new Employee("wangwu", 22);

        RandomAccessFile ra = null;
        RandomAccessFile raf = null;
        String path = "d:\\employee.txt";
        try {
            File file = new File(path);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();

            ra = new RandomAccessFile(path, "rw");
            ra.write(e1.name.getBytes());
            ra.writeInt(e1.age);
            ra.write(e2.name.getBytes());
            ra.writeInt(e2.age);
            ra.write(e3.name.getBytes());
            ra.writeInt(e3.age);
            ra.close();

            raf = new RandomAccessFile(path, "r");
            int length = 8;
            raf.skipBytes(12);   //  跳过第一个员工信息
            System.out.println("第二个员工信息");
            String str = "";
            for (int i = 0; i < length; i++) {
                str += (char) raf.readByte();
            }
            System.out.println("姓名：" + str);
            System.out.println("年龄：" + raf.readInt());

            raf.seek(0);    //  定位到最前
            System.out.println("第一个员工信息");
            str = "";
            for (int i = 0; i < length; i++) {
                str += (char) raf.readByte();
            }
            System.out.println("姓名：" + str);
            System.out.println("年龄：" + raf.readInt());

            raf.skipBytes(12);  //  跳过第二个员工信息
            System.out.println("第三个员工信息");
            str = "";
            for (int i = 0; i < length; i++) {
                str += (char) raf.readByte();
            }
            System.out.println("姓名：" + str);
            System.out.println("年龄：" + raf.readInt());
            raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Employee {

    String name;

    int age;

    final static int LEN = 8;

    public Employee(String name, int age) {
        if (name.length() > LEN) {
            this.name = name.substring(LEN);
        } else {
            while (name.length() < LEN) {
                name += "\u0000";
            }
            this.name = name;
        }
        this.age = age;
    }
}