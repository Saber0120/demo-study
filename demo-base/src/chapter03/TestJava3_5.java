package chapter03;

/**
 * 下面的这段程序当整型发生溢出之后，用强制类型进行转换
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_5 {

    public static void main(String[] args) {
        int x = Integer.MAX_VALUE;

        System.out.println("x = " + x); //  x = 2147483647
        System.out.println("x+1 = " + (x + 1)); //  x+1 = -2147483648
        System.out.println("x+2 = " + (x + 2L));    //  x+2 = 2147483649
        System.out.println("x+3 = " + ((long) x + 3));  //  x+3 = 2147483650
    }
}
