package pl.sda.shop.web;

import pl.sda.shop.repository.ProductCatalogue;
import pl.sda.shop.repository.ProductCatalogueFactory;
import pl.sda.shop.security.HttpSessionUserService;
import pl.sda.shop.security.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletsInitializer implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {

		UserService userService = new HttpSessionUserService();
		ProductCatalogue products = ProductCatalogueFactory
			.getCatalogue();
		ServletContext context = event.getServletContext();
		context.addServlet("AddProduct",
			new AddProductServlet(products, userService))
			.addMapping("/addProduct");
		context.addServlet("SearchProduct",
			new SearchProductServlet(products))
			.addMapping("/searchProduct");
		context.addServlet("Login",new LoginServlet( userService))
				.addMapping("/login");
	}
}
