package chapter13.sub02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 经典的Socket案例
 * Created by sheng on 2018/8/2.
 */
public class EchoServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            serverSocket = new ServerSocket(2222);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Socket clientSocket = null;


        while (true) {
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Hello!...");
                out.println("Enter BYE to exit!");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            while (true) {
                String str = "";
                try {
                    str = in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (str == null) {
                    break;
                } else {
                    out.println("Echo:" + str);
                    out.flush();
                    if (str.trim().equalsIgnoreCase("BYE")) {
                        break;
                    }
                }
            }
            out.close();
            try {
                in.close();
                clientSocket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
