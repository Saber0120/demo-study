package chapter10.sub06;

import java.io.*;

/**
 * 虚拟、临时文件
 * Created by sheng on 2018/8/1.
 */
public class ByteArrayDemo {

    public static void main(String[] args) {
        String tmp = "abasdfsdfasdf";
        ByteArrayInputStream input = new ByteArrayInputStream(tmp.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new ByteArrayDemo().transfer(input, out);
        byte[] result = out.toByteArray();
        System.out.println(new String(result));
    }

    void transfer(InputStream in, OutputStream out) {
        int c = 0;
        try {
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
