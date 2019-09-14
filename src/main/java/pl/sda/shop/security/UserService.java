package pl.sda.shop.security;

import pl.sda.shop.model.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    User currentUser(HttpServletRequest request);

    boolean login(HttpServletRequest request);
}
