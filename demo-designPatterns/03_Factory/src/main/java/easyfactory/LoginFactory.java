package easyfactory;

/**
 * Created by sheng on 2018/10/17.
 */
public class LoginFactory {

    public static Login factory(String type) {
        if ("Domain".equals(type)) {
            return new DomainLogin();
        } else if ("Password".equals(type)) {
            return new PasswordLogin();
        } else {
            throw new RuntimeException("未找到登录类型！");
        }
    }
}
