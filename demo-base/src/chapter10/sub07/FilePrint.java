package chapter10.sub07;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 打印流
 * 向文件输出
 * Created by sheng on 2018/8/1.
 */
public class FilePrint {

    public static void main(String[] args) {
        PrintWriter out = null;
        File file = new File("D:\\filePrint.txt");
        try {
            out = new PrintWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.print("FilePrint!\r\n");
        out.close();
    }
}
