package chapter10.sub11;

/**
 * 设置jdk编码
 * Created by sheng on 2018/8/2.
 */
public class SetDemo {

    public static void main(String[] args) {
        System.getProperties().put("file.encoding", "UTF-8");
    }
}
