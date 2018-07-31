package chapter07;

/**
 * 异常的捕获
 * Created by sheng on 2018/7/31.
 */
public class TestException7_2 {

    public static void main(String[] args) {
        int[] arr = new int[5];

        try {
            arr[10] = 7;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组下标越界！");
            System.out.println("异常：" + e);  //  异常：java.lang.ArrayIndexOutOfBoundsException: 10
        } finally {
            System.out.println("finally一定会执行！");
        }
        System.out.println("main方法结束！");
    }
}
