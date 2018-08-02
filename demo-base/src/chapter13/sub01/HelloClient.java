package chapter13.sub01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by sheng on 2018/8/2.
 */
public class HelloClient {

    public static void main(String[] args) {
        Socket clientSocket = null;
        BufferedReader in = null;
        //  将输入输出流与Socket关联
        try {
            clientSocket = new Socket("localhost", 9999);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(in.readLine());
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
