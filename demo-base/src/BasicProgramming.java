/**
 * Created by sheng on 2018/7/19.
 */
public class BasicProgramming {

    public static void main(String[] args) {
        // 3.1 变量与数据类型
        // 3.1.1 变量与常量
        /*int num = 3;
        char c = 'x';
        System.out.println(num + "是整数");
        System.out.println(c + "是字符");*/

        // 3.1.2 Java 的变量类型

        // 3.1.3 基本数据类型
        // long num = 329852547553; // integer number too large

        // 溢出的发生
        /*int num = Integer.MAX_VALUE;
        System.out.println(num); // 2147483647
        System.out.println(num + 1); // -2147483648
        System.out.println(num + 1L); // 2147483648*/

        // 在计算机的世界里，所有的文字、数值都只是一连串的 0 与 1。这些 0 与 1 对于
        // 设计者来说实在是难以理解，于是就产生了各种方式的编码。它们指定一个数值来代
        // 表某个字符，如常用的字符码系统 ASCII。
        // Unicode 就是为了避免上述情况的发生而产生的，它为每个字符制订了一个唯一
        // 的数值，因此在任何的语言、平台、程序中都可以安心地使用。Java 所使用的就是
        // Unicode 字符码系统。举例来说，Unicode 中的小写 a 是以 97 来表示
        /*char ch1 = 97;
        char ch2 = 'a';
        System.out.println(ch1); // a
        System.out.println(ch2); // a*/

        // 转义字符:\f换页;\b回退一格;\r归位;\t跳格;\\;\';\";\n
        /*char ch = '\"';
        System.out.println(ch + "测试转义字符" + ch);*/

        // 浮点数类型与双精度浮点数类型
        /*float num = 3.0f;
        System.out.println(num * num); // 9.0*/

        // 3.1.4 数据类型的转换
        // 3.1.4.1 自动类型转换
        // 1、 转换前的数据类型与转换后的类型兼容。
        // 2、 转换后的数据类型的表示范围比转换前的类型大。
        /*int a = 156;
        float b = 24.0f;
        System.out.println("a=" + a + ",b=" + b); // a=156,b=24.0
        System.out.println("a/b=" + a/b); // a/b=6.5*/
        // 3.1.4.2 强制类型转换
        /*int a,b;
        float g,h;
        a = 55;
        b = 9;
        g = a/b;
        System.out.println("a=" + a + ",b=" + b); // a=55,b=9
        System.out.println("g=" + g); // g=6.0
        h = (float) a/b; // 或a/(float) b 或 (float) a/(float) b
        System.out.println("h=" + h); // h=6.111111*/

        // 3.2 运算符、表达式与语句
        // 3.2.1 表达式与运算符:表达式是由操作数与运算符所组成,运算符可分为赋值运算符、算术运算符、关系运算符、逻辑运算符、条件运算符、括号运算符等
        // 3.2.1.1 赋值运算符号:=
        /*int num = 22;
        System.out.println("num=" + num); // num=22
        num = num - 3;
        System.out.println("num=" + num); //  将变量 num 的值减三之后再赋给 num 变量,num=19*/
        // 3.2.1.2 一元运算符:+正,-负,!否,~取补
        /*byte a = Byte.MAX_VALUE;
        boolean b = false;
        System.out.println("a=" + a + ",~a=" + ~a); // a=127,~a=-128
        System.out.println("b=" + b + ",!b=" + !b); // b=false,!b=true*/


    }
}
