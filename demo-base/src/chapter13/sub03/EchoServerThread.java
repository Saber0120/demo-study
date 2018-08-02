package chapter13.sub03;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Echo多线程版本
 * Created by sheng on 2018/8/2.
 */
public class EchoServerThread {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(3333);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (listening) {
            try {
                new EchoMultiServerThread(serverSocket.accept()).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
