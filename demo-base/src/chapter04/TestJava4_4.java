package chapter04;

/**
 * 以下这段程序说明数组的拷贝操作
 * Created by sheng on 2018/7/20.
 */
public class TestJava4_4 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        //  System.arrayCopy(source,0,dest,0,x)：复制数组源从下表0开始的x个元素至目标数组
        //  length大于数组源长度时 或 大于目标数组长度时，报下标越界
        System.arraycopy(a, 0, b, 0, 3);

        System.out.print("数组a的元素有：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i] + " ");
        }
        System.out.println();

        System.out.print("数组b的元素有：");
        for (int i = 0; i < b.length; i++) {
            System.out.print(" " + b[i] + " ");
        }
        System.out.println();
    }
}
