package chapter05;

/**
 * Created by Administrator on 2018/7/20.
 */
public class TestRefDemo2 {

    public static void main(String[] args) {
        Change c = new Change();
        c.x = 20;
        fun(c);
        System.out.println(c.x);    //  25
    }

    public static void fun(Change c) {
        c.x = 25;
    }
}

class Change {
    int x;
}
