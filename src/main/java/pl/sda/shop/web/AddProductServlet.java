package pl.sda.shop.web;

import pl.sda.shop.model.Product;
import pl.sda.shop.model.User;
import pl.sda.shop.model.UserRole;
import pl.sda.shop.repository.ProductCatalogue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {

    private ProductCatalogue products;

    public AddProductServlet(ProductCatalogue products) {
        this.products = products;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        boolean success = false;
        if(user != null){
            success = user.hasRole(UserRole.ADMIN);
            if (success) {
                products.add(new Product(
                        req.getParameter("name"),
                        Integer.parseInt(req.getParameter("price")),
                        Integer.parseInt(req.getParameter("quantity"))));
            }
        }

        resp.sendRedirect("/addProduct?success="+success);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addProductForm.jsp").forward(req, resp);
    }
}