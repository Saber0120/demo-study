/**
 * 缺省适配器
 * 当接口中方法并不需要全部实现时，可以创建一个缺省类，来实现接口，并提供缺省的实现方法，其他实现类只需继承该缺省类即可只重写自己所需要的方法
 * 该方法仅建议在出现接口设计重大失误时使用
 * Created by sheng on 2018/6/27.
 */
public class DefaultPerson implements Person {

    @Override
    public void speak() {

    }

    @Override
    public void work() {

    }

    @Override
    public void listen() {

    }
}
