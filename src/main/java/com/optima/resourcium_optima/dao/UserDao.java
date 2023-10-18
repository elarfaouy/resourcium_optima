package com.optima.resourcium_optima.dao;

import com.optima.resourcium_optima.entities.User;
import jakarta.persistence.*;

import java.util.List;

public class UserDao {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("optima");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final EntityTransaction entityTransaction = entityManager.getTransaction();

    public void createUser(User user) {
        entityTransaction.begin();
        entityManager.persist(user);
        entityTransaction.commit();
    }

    public User updateUser(User user) {
        entityTransaction.begin();
        User user1 = entityManager.merge(user);
        entityTransaction.commit();
        return user1;
    }

    public void deleteUser(Long id) {
        entityTransaction.begin();
        User user = entityManager.find(User.class, id);
        if (user != null) entityManager.remove(user);
        entityTransaction.commit();
    }

    public User getUserById(Long userId) {
        entityTransaction.begin();
        User user = entityManager.find(User.class, userId);
        entityTransaction.commit();
        return user;
    }

    public User getUserByUsername(String username) {
        try {
            entityTransaction.begin();
            TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
            query.setParameter("username", username);
            entityTransaction.commit();
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<User> getAllUsers() {
        entityTransaction.begin();
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        entityTransaction.commit();
        return query.getResultList();
    }
}
