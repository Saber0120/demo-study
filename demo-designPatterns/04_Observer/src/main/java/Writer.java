import java.util.Observable;

/**
 * Created by sheng on 2018/6/20.
 */
public class Writer extends Observable {

    private String name;

    private String lastNovel;

    public Writer(String name) {
        this.name = name;
        WriterManager.getInstance().addWriter(this);
    }

    public void addNovel(String novel) {
        System.out.println(name + "发布了新书《" + novel + "》!");
        lastNovel = novel;
        setChanged();
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public String getLastNovel() {
        return lastNovel;
    }
}
