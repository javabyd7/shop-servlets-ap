package pl.sda.shop;

import org.apache.catalina.startup.Tomcat;
import pl.sda.shop.web.EmbeddedTomcatFactory;

public class App {
	public static void main(String[] args) throws Exception {
		Tomcat tomcat = create();
		tomcat.start();
		tomcat.getServer().await();
	}

	private static Tomcat create() throws Exception {
		return EmbeddedTomcatFactory.create(8080);
	}
}
