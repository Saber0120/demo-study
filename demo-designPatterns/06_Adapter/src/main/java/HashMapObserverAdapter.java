import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * 1、类适配器
 * 希望得到一个实现了某接口(Observer)的类(HashMap)，但是又不能直接修改这个类(HashMap)
 * 通过继承该类(HashMap)，并且实现某接口(Observer)来实现
 *
 * Created by sheng on 2018/6/27.
 */
public class HashMapObserverAdapter extends HashMap implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        super.clear();
    }
}
