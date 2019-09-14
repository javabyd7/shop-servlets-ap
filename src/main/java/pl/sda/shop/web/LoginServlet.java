package pl.sda.shop.web;

import pl.sda.shop.model.User;
import pl.sda.shop.model.UserRole;
import pl.sda.shop.security.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService;

    public LoginServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ( userService.login(req)){
            resp.sendRedirect("/addProduct");
        } else {
            resp.sendRedirect("/login?success=false");
        }
    }
}
