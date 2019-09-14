package pl.sda.shop.web;

import pl.sda.shop.model.Product;
import pl.sda.shop.repository.ProductCatalogue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

//@WebServlet("/searchProduct")
public class SearchProductServlet extends HttpServlet {
	private ProductCatalogue products;

	public SearchProductServlet(ProductCatalogue products) {
		this.products = products;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nameParam = req.getParameter("name");
		Collection<Product> productsCollectionAttribute;
		if (nameParam == null) {
			productsCollectionAttribute = products.findAll();
		}
		else {
			productsCollectionAttribute = Collections
				.singleton(products.findByName(nameParam)
					.orElse(null));
		}
		req.setAttribute("products", productsCollectionAttribute);
		req.getRequestDispatcher("searchProductForm.jsp")
			.forward(req, resp);
	}
}