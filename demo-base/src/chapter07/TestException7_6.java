package chapter07;

/**
 * 自定义异常
 * 继承Exception
 * Created by sheng on 2018/7/31.
 */
public class TestException7_6 {

    public static void main(String[] args) {
        try {
            throw new DefaultException("自定义异常");
        } catch (Exception e) {
            System.out.println(e);  //  chapter07.DefaultException: 自定义异常
        }
    }
}

class DefaultException extends Exception {

    public DefaultException(String message) {
        super(message);
    }
}