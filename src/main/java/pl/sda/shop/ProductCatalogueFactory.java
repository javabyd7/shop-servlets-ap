package pl.sda.shop;

import pl.sda.shop.repository.JpaProductCatalogue;
import pl.sda.shop.repository.ProductCatalogue;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ProductCatalogueFactory {
	public static ProductCatalogue getCatalogue() {
		EntityManager entityManager = Persistence
			.createEntityManagerFactory("shop")
			.createEntityManager();
		return new JpaProductCatalogue(entityManager);
	}
}
