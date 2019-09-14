package pl.sda.shop.web;

import pl.sda.shop.model.User;
import pl.sda.shop.model.UserRole;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("admin".equals(req.getParameter("login")) && "pass".equals(req.getParameter("password"))){
            req.getSession().setAttribute("user",new User("admin", UserRole.ADMIN));
            resp.sendRedirect("/addProduct");
        } else {
            resp.sendRedirect("/login?success=false");
        }
    }
}
