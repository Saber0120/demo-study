package easyfactory;

/**
 * Created by sheng on 2018/10/17.
 */
public class PasswordLogin implements Login {

    @Override
    public void verify() {
        System.out.println("Password Login!");
    }
}
