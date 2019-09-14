package pl.sda.shop.web;

import pl.sda.shop.repository.ProductCatalogueFactory;
import pl.sda.shop.repository.ProductCatalogue;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletsInitializer implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ProductCatalogue products = ProductCatalogueFactory
			.getCatalogue();
		ServletContext context = event.getServletContext();
		context.addServlet("AddProduct",
			new AddProductServlet(products))
			.addMapping("/addProduct");
		context.addServlet("SearchProduct",
			new SearchProductServlet(products))
			.addMapping("/searchProduct");
		context.addServlet("Login",new LoginServlet())
				.addMapping("/login");
	}
}
