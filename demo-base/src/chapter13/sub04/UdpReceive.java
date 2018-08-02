package chapter13.sub04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * DatagramSocket：自寻址套接字
 * Created by sheng on 2018/8/2.
 */
public class UdpReceive {

    public static void main(String[] args) {
        DatagramSocket ds = null;
        byte[] buf = new byte[1024];
        DatagramPacket dp = null;

        try {
            ds = new DatagramSocket(9000);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        dp = new DatagramPacket(buf, 1024);
        try {
            ds.receive(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String str = new String(dp.getData(), 0, dp.getLength()) + " from " + dp.getAddress().getHostAddress() + ":" + dp.getPort();
        System.out.println(str);
        ds.close();
    }
}
