package chapter10.sub09;

import java.io.*;

/**
 * 合并流
 * Created by sheng on 2018/8/1.
 */
public class SequenceDemo {

    public static void main(String[] args) {
        InputStream in1 = null;
        InputStream in2 = null;
        SequenceInputStream s = null;
        OutputStream out = null;

        try {
            in1 = new FileInputStream("D:\\1.txt");
            in2 = new FileInputStream("D:\\2.txt");
            s = new SequenceInputStream(in1, in2);
            out = new FileOutputStream("D:\\12.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int c;
        try {
            while ((c = s.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            in1.close();
            in2.close();
            s.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
