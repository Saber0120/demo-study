package chapter10.sub01;

import java.io.File;
import java.io.IOException;

/**
 * File类
 * Created by sheng on 2018/8/1.
 */
public class FileDemo {

    public static void main(String[] args) {
        File file = new File("D:\\1.txt");
        if (file.exists()) {
            file.delete();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("文件名：" + file.getName());
            System.out.println("文件路径：" + file.getPath());
            System.out.println("绝对路径：" + file.getAbsolutePath());
            System.out.println("父文件夹名称：" + file.getParent());
            System.out.println("文件是否存在：" + file.exists());
            System.out.println("文件是否可写：" + file.canWrite());
            System.out.println("文件是否可读：" + file.canRead());
            System.out.println("是否是目录：" + file.isDirectory());
            System.out.println("是否是文件：" + file.isFile());
            System.out.println("是否是绝对路径：" + file.isAbsolute());
            System.out.println("最后修改时间：" + file.lastModified());
            System.out.println("文件大小：" + file.length() + "Bytes");
        }
    }
}
