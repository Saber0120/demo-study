package chapter10.sub08;

import java.io.*;

/**
 * 提供与平台无关的数据操作，通常先通过DataOutputStream按一定格式输出，在用DataInputStream按一定格式读入
 * Created by sheng on 2018/8/1.
 */
public class DataInputStreamDemo {

    public static void main(String[] args) {
        File file = new File("D:\\dataInputStream.txt");
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new FileOutputStream("D:\\dataInputStream.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] descs = {"T恤杉", "杯子", "洋娃娃", "大头针", "钥匙链"};   //  产品名称
        int[] units = {10, 10, 20, 39, 40}; //  产品数目
        double[] prices = {18.99, 9.22, 14.22, 5.22, 4.21};   //  产品价格

        for (int i = 0; i < 5; i++) {
            try {
                out.writeChars(descs[i]);
                out.writeChar('\t');
                out.writeInt(units[i]);
                out.writeChar('\t');
                out.writeDouble(prices[i]);
                out.writeChar('\n');
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //  以下为读取数据
        DataInputStream input = null;
        try {
            input = new DataInputStream(new FileInputStream("D:\\dataInputStream.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        double price = 0;
        int unit = 0;
        StringBuilder builder = new StringBuilder();
        double total = 0;

        try {
            while (true) {
                char ch;

                builder = new StringBuilder();
                while ((ch = input.readChar()) != '\t') {
                    builder.append(ch);
                }
                unit = input.readInt();
                input.readChar();
                price = input.readDouble();
                input.readChar();
                total += unit * price;

                System.out.println("产品信息：" + "产品名称：" + builder.toString() + "\t" + "产品数目：" + unit + "\t" + "产品价格：" + price + "\n");

            }
        } catch (IOException e) {
            System.out.println("产品总价格：" + total);
        }
    }
}
