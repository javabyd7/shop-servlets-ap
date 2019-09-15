package pl.sda.shop.security;

import pl.sda.shop.model.User;
import pl.sda.shop.model.UserRole;
import pl.sda.shop.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;

public class HttpSessionUserService implements UserService {

    private UserRepository userRepository;

    public HttpSessionUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        return userRepository
                .findByName(login)
                .filter(u -> u.getPassword().equals(password))
                .map(u -> {
                    request.getSession().setAttribute("user", u);
                    return true;
                })
                .orElse(false);
    }
}
