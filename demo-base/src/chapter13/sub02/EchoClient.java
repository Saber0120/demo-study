package chapter13.sub02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by sheng on 2018/8/2.
 */
public class EchoClient {

    public static void main(String[] args) {
        Socket clientSocket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            clientSocket = new Socket("localhost", 2222);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(in.readLine());
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));

        String userInput;
        try {
            while ((userInput = systemIn.readLine()) != null) {
                out.println(userInput);
                System.out.println(in.readLine());
            }
            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
