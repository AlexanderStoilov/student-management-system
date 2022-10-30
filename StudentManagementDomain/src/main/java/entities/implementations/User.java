package entities.implementations;

import entities.enums.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;
    private String password;
    private UserType type;

    public User() {
    }

    public User(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = UserType.valueOf(type);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

}
