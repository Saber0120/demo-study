package chapter02;

/**
 * 下面这段程序原本是要计算一共有多少本书，但是由于错把加号写成了减号，所以造成了输出结果不正确属于语义错误
 * Created by sheng on 2018/7/20.
 */
public class TestJava2_5 {

    public static void main(String[] args) {
        int num1 = 4;
        int num2 = 5;

        System.out.println("我有 " + num1 + " 本书！");
        System.out.println("你有 " + num2 + " 本书！");
        System.out.println("我们一共有 " + (num1 - num2) + " 本书！");  //  应该是num1+num2
    }
}
