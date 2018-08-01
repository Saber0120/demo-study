package chapter10.sub03;

import java.io.*;

/**
 * 字节流
 * Created by sheng on 2018/8/1.
 */
public class StreamDemo {

    public static void main(String[] args) {
        //  以下为写入文件
        File file = new File("D:\\temp.txt");
        OutputStream out = null;
        try {
            //  创建时不需要判断文件是否存在，会自动创建
//            out = new FileOutputStream(file); //  每次写都覆盖之前的
            out = new FileOutputStream(file, true); //  基于上次写的末尾继续写
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] b = "Hello Stream!!!".getBytes();
        try {
            out.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //  以下为读取文件
        InputStream input = null;
        try {
            input = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] bytes = new byte[1024];
        int i = 0;
        try {
            i = input.read(bytes);  //  读取到的字节数
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(bytes, 0, i));
    }
}
