package chapter10.sub11;

import java.io.*;

/**
 * 字符编码
 *
 * Created by sheng on 2018/8/2.
 */
public class EncodingDemo {

    public static void main(String[] args) {
        //  将字符串编码成GB2312
        try {
            byte[] bytes = "字符编码测试".getBytes("ISO8859-1");
            OutputStream out = new FileOutputStream(new File("d:\\encoding.txt"));
            out.write(bytes);
            out.close();    //  GB2312、GBK、UTF-8、Unicode:txt文件中显示正常;ISO8859-1:一堆问号


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
