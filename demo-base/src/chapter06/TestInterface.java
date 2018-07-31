package chapter06;

/**
 * Created by sheng on 2018/7/31.
 */
public class TestInterface {

    public static void main(String[] args) {
        new Computer().work(new MovieDisk());
        new Computer().work(new Mp3());
    }
}

interface Usb {

    void start();

    void stop();
}

class Mp3 implements Usb {

    @Override
    public void start() {
        System.out.println("Mp3 usb start!");
    }

    @Override
    public void stop() {
        System.out.println("Mp3 usb stop!");
    }
}

class MovieDisk implements Usb {

    @Override
    public void start() {
        System.out.println("MovieDisk usb start!");
    }

    @Override
    public void stop() {
        System.out.println("MovieDisk usb stop!");
    }
}

class Computer {

    void work(Usb usb) {
        usb.start();
        usb.stop();
    }
}