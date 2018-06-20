import java.util.Observable;
import java.util.Observer;

/**
 * Created by sheng on 2018/6/20.
 */
public class Reader implements Observer {

    private String name;

    public Reader(String name) {
        this.name = name;
    }

    public void subscribe(String writerName) {
        WriterManager.getInstance().getWriter(writerName).addObserver(this);
    }

    public void unSubscribe(String writerName) {
        WriterManager.getInstance().getWriter(writerName).deleteObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Writer) {
            Writer writer = (Writer) o;
            System.out.println(name + "知道" + writer.getName() + "发布了新书《" + writer.getLastNovel() + "》，一定要去看");
        }
    }
}
