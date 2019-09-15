package pl.sda.shop.repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class UserRepositoryFactory {

    public static UserRepository getUserRepository(){
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("shop")
                .createEntityManager();

        return new JpaUserRepository(entityManager);

    }
}
