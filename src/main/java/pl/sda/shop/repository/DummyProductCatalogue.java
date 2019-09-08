package pl.sda.shop.repository;

import pl.sda.shop.model.Product;

import java.util.HashSet;
import java.util.Set;

public class DummyProductCatalogue implements ProductCatalogue {

    Set<Product> products;

    public DummyProductCatalogue() {
        this.products = new HashSet<>();
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }
}