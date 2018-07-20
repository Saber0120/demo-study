package chapter03;

/**
 * 以下程序说明了多分支条件语句的使用
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_27 {

    public static void main(String[] args) {
        int a = 100, b = 7;
        char oper = '/';

        switch (oper) {
            case '+':
                System.out.println(a + " + " + b + " = " + (a + b));
                break;
            case '-':
                System.out.println(a + " - " + b + " = " + (a - b));
                break;
            case '*':
                System.out.println(a + " * " + b + " = " + (a * b));
                break;
            case '/':
                System.out.println(a + " / " + b + " = " + ((float) a / b));
                break;
            default:
                System.out.println("未知的操作！");
        }
    }
}
