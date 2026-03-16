package lab.wzorce.projekt.utils.factories;

import lab.wzorce.projekt.models.User;

// Tydzień 3, Wzorzec Fabryka 1
// Wzorzec projektowy Fabryka zaimplementowany za pomocą statycznych metod fabrykujących.
// Hermetyzuje proces tworzenia obiektów klasy User, pozwalając na łatwe i czytelne generowanie użytkowników o określonych rolach  bez powielania kodu.
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
// Koniec, Tydzień 1, Wzorzec Fabryka 1.