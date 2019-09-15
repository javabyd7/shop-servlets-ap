package pl.sda.shop.repository;

import pl.sda.shop.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class JpaUserRepository implements UserRepository {

    private EntityManager entityManager;

    public JpaUserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();

    }

    @Override
    public Optional<User> findByName(String userName) {

        TypedQuery<User> query = entityManager.createQuery("SELECT u from User u where u.name = :userName", User.class);
        query.setParameter("userName", userName);
        return query.getResultList().stream().findAny();
    }
}
