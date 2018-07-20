package chapter03;

/**
 * 下面这段程序声明了两个变量，一个是整型，一个是浮点型
 * <p>
 * 自动类型转换条件：
 * 1、 转换前的数据类型与转换后的类型兼容。
 * 2、 转换后的数据类型的表示范围比转换前的类型大。
 * <p>
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_11 {

    public static void main(String[] args) {
        int a = 156;
        float b = 24.0f;

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a/b = " + (a / b)); //  这里整型会自动转化为浮点型
    }
}
