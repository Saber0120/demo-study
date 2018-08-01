package chapter10.sub04;

import java.io.*;

/**
 * 字符流
 * Created by sheng on 2018/8/1.
 */
public class CharDemo {

    public static void main(String[] args) {
        //  以下为输出文件
        File file = new File("D:\\char.txt");
        Writer writer = null;
        try {
            //  创建时不需要判断文件是否存在，会自动创建
//            writer = new FileWriter(file);    //  每次写都覆盖
            writer = new FileWriter(file, true);  //  基于上次写的末尾继续写
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = "Hello Writer!";
        try {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //  以下为读取文件内容
        Reader reader = null;
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int count = 0;
        char[] ch = new char[1024];
        try {
            count = reader.read(ch);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(ch, 0, count));
    }
}
