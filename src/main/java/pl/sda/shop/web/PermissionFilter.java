package pl.sda.shop.web;

import pl.sda.shop.model.UserRole;
import pl.sda.shop.security.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PermissionFilter extends HttpFilter {

    private UserService userService;

    public PermissionFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (userService.currentUser(req).hasRole(UserRole.ADMIN)) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect("/login");
        }
    }

}
