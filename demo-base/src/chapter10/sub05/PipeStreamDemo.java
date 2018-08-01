package chapter10.sub05;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道流：用于线程间通信
 *
 * Created by sheng on 2018/8/1.
 */
public class PipeStreamDemo {

    public static void main(String[] args) {
        //  产生两个线程对象
        Sender s = new Sender();
        Receiver r = new Receiver();

        //  写入流
        PipedOutputStream out = s.getOut();
        //  输出流
        PipedInputStream input = r.getInput();

        //  连接两个管道
        try {
            out.connect(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //  启动线程
        s.start();
        r.start();
    }
}

class Sender extends Thread {

    private PipedOutputStream out = new PipedOutputStream();

    public PipedOutputStream getOut() {
        return out;
    }

    @Override
    public void run() {
        String str = "Hello Pipe";

        try {
            out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Receiver extends Thread {

    private PipedInputStream input = new PipedInputStream();

    public PipedInputStream getInput() {
        return input;
    }

    public void setInput(PipedInputStream input) {
        this.input = input;
    }

    @Override
    public void run() {
        byte[] bytes = new byte[1024];
        int n = 0;
        try {
            n = input.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(bytes, 0, n));
    }
}