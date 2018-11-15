package easyfactory;

/**
 * Created by sheng on 2018/10/17.
 */
public class DomainLogin implements Login {

    @Override
    public void verify() {
        System.out.println("Domain Login!");
    }
}
