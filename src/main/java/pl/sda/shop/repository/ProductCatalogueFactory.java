package pl.sda.shop.repository;

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
