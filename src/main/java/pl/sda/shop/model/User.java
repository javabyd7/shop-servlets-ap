package pl.sda.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
@Entity
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private String password;

    public User(String name, String password , UserRole role) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(role);
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public User(String name, UserRole role) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(role);
        this.name = name;
        this.role = role;
    }

    public boolean hasRole(UserRole role) {
        return this.role.ensures(role);
    }
}
