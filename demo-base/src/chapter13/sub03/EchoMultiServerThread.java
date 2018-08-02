package chapter13.sub03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by sheng on 2018/8/2.
 */
public class EchoMultiServerThread extends Thread {

    private Socket clientSocket;

    public EchoMultiServerThread(Socket clientSocket) {
        super("EchoMultiServerThread");
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        PrintWriter out = null;
        BufferedReader in = null;

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
                break;
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
//            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
