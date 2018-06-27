import java.util.Observable;

/**
 * 重写父类的方法，打开protected限制
 * Created by sheng on 2018/6/27.
 */
public class NotStupidObservable extends Observable {

    @Override
    public synchronized void clearChanged() {
        super.clearChanged();
    }

    @Override
    public synchronized void setChanged() {
        super.setChanged();
    }
}
