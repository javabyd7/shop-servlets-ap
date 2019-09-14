package pl.sda.shop.security;

import pl.sda.shop.model.User;
import pl.sda.shop.model.UserRole;

import javax.servlet.http.HttpServletRequest;

public class HttpSessionUserService implements UserService {
    private static final String LOGIN = "admin";
    private static final String PASS = "123";
    @Override
    public User currentUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            user = new User("anonymous", UserRole.ANONYMOUS);
        }
        return user;
    }

    @Override
    public boolean login(HttpServletRequest request) {
        if (LOGIN.equals(request.getParameter("login")) && PASS.equals(request.getParameter("password"))) {
            User user = new User(LOGIN, UserRole.ADMIN);
            request.getSession().setAttribute("user",user);
            return true;
        }
        return false;
    }
}
