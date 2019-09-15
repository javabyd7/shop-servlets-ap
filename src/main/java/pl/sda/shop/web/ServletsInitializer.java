package pl.sda.shop.web;

import pl.sda.shop.repository.ProductCatalogue;
import pl.sda.shop.repository.ProductCatalogueFactory;
import pl.sda.shop.repository.UserRepository;
import pl.sda.shop.repository.UserRepositoryFactory;
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

        UserRepository userRepository = UserRepositoryFactory.getUserRepository();
        UserService userService = new HttpSessionUserService(userRepository);


        ProductCatalogue products = ProductCatalogueFactory
                .getCatalogue();
        ServletContext context = event.getServletContext();

        context.addServlet("AddProduct",
                new AddProductServlet(products))
                .addMapping("/addProduct");

        context.addServlet("SearchProduct",
                new SearchProductServlet(products))
                .addMapping("/searchProduct");

        context.addFilter("PermissionFilter", new PermissionFilter(userService))
                .addMappingForUrlPatterns(null, true, "/*");

        context.addServlet("Login", new LoginServlet(userService))
                .addMapping("/login");

        context.addServlet("Register", new RegisterServlet(userRepository))
                .addMapping("/register");
    }
}
