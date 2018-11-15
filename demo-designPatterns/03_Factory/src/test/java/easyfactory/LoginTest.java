package easyfactory;

import org.junit.Test;

/**
 * Created by sheng on 2018/10/17.
 */
public class LoginTest {

    @Test
    public void verify() throws Exception {
        Login login = null;
        String type = "Domain";
        login(type);

        type = "Password";
        login(type);
    }

    private void login(String type) {
        Login login;
        login = LoginFactory.factory(type);
        login.verify();
    }

}