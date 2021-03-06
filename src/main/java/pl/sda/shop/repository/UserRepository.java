package pl.sda.shop.repository;

import pl.sda.shop.model.User;

import java.util.Optional;

public interface UserRepository {

    void add(User user) throws UserAlreadyExistsExeption;
    Optional<User> findByName(String userName);

}
