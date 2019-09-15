package pl.sda.shop.web;

import pl.sda.shop.model.UserRole;
import pl.sda.shop.security.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PermissionFilter extends HttpFilter {

    private UserService userService;
    private static Map<String,UserRole> map;

    public PermissionFilter(UserService userService) {
        this.userService = userService;
        map = new HashMap<>();
        map.put("/addProduct",UserRole.ADMIN);
        map.put("/searchProduct", UserRole.REGULAR);
        map.put("/register", UserRole.ADMIN);
        map.put("/login", UserRole.ANONYMOUS);
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (userService.currentUser(req).hasRole(map.getOrDefault(req.getServletPath(), UserRole.ADMIN))) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect("/login");
        }
    }

}
