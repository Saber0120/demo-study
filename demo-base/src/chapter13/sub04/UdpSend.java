package chapter13.sub04;

import java.io.IOException;
import java.net.*;

/**
 * Created by sheng on 2018/8/2.
 */
public class UdpSend {

    public static void main(String[] args) {
        DatagramSocket ds = null;
        DatagramPacket dp = null;

        try {
            ds = new DatagramSocket(3000);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        String str = "Hello!";
        try {
            dp = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("localhost"), 9000);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ds.close();
    }
}
