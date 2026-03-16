package lab.wzorce.projekt.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(nullable = false, unique = true)
    private String login;

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    @NotBlank
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String privilege= "user";
    @NotBlank
    @Size(min = 8)
    @Column(nullable = false)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Tydzień 1, Wzorzec Builder 1
    // Wzorzec projektowy Builder zaimplementowany w formie statycznej klasy zagnieżdżonej.
    // Umożliwia krokowe i czytelne tworzenie złożonego obiektu User), pozwalając na elastyczne ustawianie atrybutów bez potrzeby tworzenia skomplikowanych konstruktorów.
    public static class Builder {
        private String login;
        private String email;
        private String password;
        private String privilege = "user";

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder privilege(String privilege) {
            this.privilege = privilege;
            return this;
        }

        public User build() {
            User user = new User();
            user.setLogin(this.login);
            user.setEmail(this.email);
            user.setPassword(this.password);
            user.setPrivilege(this.privilege);
            return user;
        }
    }
    // Koniec, Tydzień 1, Wzorzec Builder 1.
}