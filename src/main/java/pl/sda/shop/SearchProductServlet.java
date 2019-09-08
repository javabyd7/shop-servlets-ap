package pl.sda.shop;

import pl.sda.shop.repository.ProductCatalogue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/searchProduct")
public class SearchProductServlet extends HttpServlet {

    ProductCatalogue products;

    public SearchProductServlet(ProductCatalogue products) {
        this.products = products;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", products.findByName(req.getParameter("name")).orElse(null));
        req.getRequestDispatcher("searchProductForm.jsp").forward(req, resp);
    }
}