package pl.sda.shop.web;

import pl.sda.shop.model.User;
import pl.sda.shop.model.UserRole;
import pl.sda.shop.repository.UserAlreadyExistsExeption;
import pl.sda.shop.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private UserRepository userRepository;

    public RegisterServlet(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        try {
            userRepository.add(new User(login, password, UserRole.REGULAR));
            resp.sendRedirect("/login?success=true");
        } catch (UserAlreadyExistsExeption e){
            e.printStackTrace();
            resp.sendRedirect("/register?success=false");
        }
    }
}
