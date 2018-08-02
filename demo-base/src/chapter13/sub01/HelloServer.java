package chapter13.sub01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket服务端，向客户端发送信息
 * Created by sheng on 2018/8/2.
 */
public class HelloServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        PrintWriter out = null;
        try {
            //  创建了一个服务端的Socket连接
            serverSocket = new ServerSocket(9999);
        } catch (IOException e) {
            System.out.println("Could not listen on port : 9999!");
            e.printStackTrace();
        }
        Socket clientSocket = null;
        try {
            //  accept()用来监听客户端的连接
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed!");
            e.printStackTrace();
        }
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.print("Hello Client!");
        out.close();
        try {
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
