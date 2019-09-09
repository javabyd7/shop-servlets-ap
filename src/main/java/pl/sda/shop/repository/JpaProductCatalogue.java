package pl.sda.shop.repository;

import pl.sda.shop.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Optional;

public class JpaProductCatalogue implements ProductCatalogue {

    private EntityManager entityManager;

    public JpaProductCatalogue(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    public void add(Product product) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(product);
        transaction.commit();
    }

    @Override
    public Optional<Product> findByName(String name) {
        return Optional.ofNullable(entityManager.find(Product.class, name));
    }
}
