/**
 * Created by sheng on 2018/6/20.
 */
public class Test {

    public static void main(String[] args) {
        Writer writer1 = new Writer("作者1");
        Writer writer2 = new Writer("作者2");
        Reader reader1 = new Reader("读者1");
        Reader reader2 = new Reader("读者2");
        Reader reader3 = new Reader("读者3");
        Reader reader4 = new Reader("读者4");

        reader1.subscribe(writer1.getName());
        reader1.subscribe(writer2.getName());
        reader2.subscribe(writer1.getName());
        reader2.subscribe(writer2.getName());
        reader3.subscribe(writer1.getName());
        reader4.subscribe(writer1.getName());

        writer1.addNovel("设计模式");
        writer2.addNovel("JAVA编程思想");

        reader1.unSubscribe(writer2.getName());
        writer2.addNovel("book");
    }
}
