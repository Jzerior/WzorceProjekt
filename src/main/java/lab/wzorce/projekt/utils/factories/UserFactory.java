package lab.wzorce.projekt.utils.factories;

import lab.wzorce.projekt.models.User;

public class UserFactory {
    public static User createAdmin(String login, String email, String password) {
        User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);
        user.setPrivilege("admin");
        return user;
    }

    public static User createCustomer(String login, String email, String password) {
        User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);
        user.setPrivilege("user");
        return user;
    }
}