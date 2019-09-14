package pl.sda.shop.repository;

import pl.sda.shop.model.Product;

import java.util.Collection;
import java.util.Optional;

public interface ProductCatalogue {
	void add(Product product);

	Optional<Product> findByName(String name);

	Collection<Product> findAll();
}
