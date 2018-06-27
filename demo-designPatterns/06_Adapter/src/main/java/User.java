/**
 * 对象适配器
 * 当类(User)已经继承一个类(BaseEntity)时，此时不能再继承另一个类(Observable)
 * 可以创建一个中间类(BaseObservableEntity)来继承类(BaseEntity)，中间类里创建另一个类(Observable)的对象，添加方法调用该类的方法
 * 类(User)再继承该中间类(BaseObservableEntity)，这样既不破坏原来的类(BaseEntity)继承，也实现了添加另一个类(Observable)的功能
 * 如果只有一个类(User)需要添加新功能，可以不建中间类，直接在User中添加另一个类的对象（本例中因为要重写Observable类的两个protected方法，所以只能使用中间类）
 *
 * Created by sheng on 2018/6/27.
 */
public class User extends BaseObservableEntity {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
