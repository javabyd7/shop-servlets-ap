package pl.sda.shop.model;

import java.util.Objects;

public class User {

    private final String name;
    private final UserRole role;

    public User(String name, UserRole role) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(role);
        this.name = name;
        this.role = role;
    }

    public boolean hasRole(UserRole role) {
        return role.equals(this.role);
    }
}
