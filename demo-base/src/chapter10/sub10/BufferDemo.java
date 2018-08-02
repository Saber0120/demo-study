package chapter10.sub10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字节流与字符流的转换
 * InputStreamReader和OutputStreamWriter这两个类是字节流与字符流之间转换的类
 * 1、InputStreamReader  可以将字节流中的字节解码为字符
 * 构造函数：InputStreamReader(InputStream in);InputStreamReader(InputStream in, String charsetName);
 * 2、OutputStreamWriter 可以将写入的字符编码成字节后写入字节流
 * 构造函数：OutputStreamWriter(OutputStream out);OutputStreamWriter(OutputStream out, String charsetName);
 * 3、一般都不直接使用，使用包装类BufferWriter和BufferReader
 * BufferedWriter out = new BufferWriter(new OutputStreamWriter(System.out));
 * BufferedReader in = new BufferReader(new InputStreamReader(System.in));
 * Created by sheng on 2018/8/2.
 */
public class BufferDemo {

    public static void main(String[] args) {
        //  接收键盘输入，并输出：键盘输入是字节流，输出是字符，所以要将字节流转换为字符
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while (true) {
            System.out.print("请输入数字");
            try {
                str = br.readLine();    //  等待键盘输入
            } catch (IOException e) {
                e.printStackTrace();
            }

            int i = -1;
            try {
                i = Integer.parseInt(str);
                i++;
                System.out.println("修改后的数字是" + i);
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入的数字有误");
            }
        }
    }
}
