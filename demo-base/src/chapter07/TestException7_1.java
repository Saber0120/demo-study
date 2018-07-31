package chapter07;

/**
 * 简单的异常
 * 1、ArrayIndexOutOfBoundsException：下标越界
 *
 * 处理异常：
 * 1、jdk默认处理机制：输出异常信息，程序终止
 * 2、自行编写try-catch-finally处理异常，好处是可以灵活控制程序流程。
 *
 * 异常的结构：
 * 主要又有IOExcetion和RuntimeException
 * RuntimeException：不写异常处理的代码编译也可通过
 * IOException：必须写异常处理的程序代码才可编译通过
 * Created by sheng on 2018/7/31.
 */
public class TestException7_1 {

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[10] = 10;   //  此处发生ArrayIndexOutOfBoundsException异常，且没有编写处理异常的代码，所以程序直接结束。
        System.out.println("end");
    }
}
