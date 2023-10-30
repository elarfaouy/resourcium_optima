package com.optima.resourcium_optima.repositories;

import com.optima.resourcium_optima.domain.entities.Department;
import com.optima.resourcium_optima.domain.entities.Role;
import com.optima.resourcium_optima.domain.entities.User;
import com.optima.resourcium_optima.util.EntityManagerUtil;
import jakarta.persistence.*;

import java.util.List;

public class UserDao {
    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

    public void createUser(User user) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(user.getRole());
            entityManager.persist(user.getDepartment());
            entityManager.persist(user);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw e;
        }
    }

    public User updateUser(User user) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            User user1 = entityManager.merge(user);
            entityTransaction.commit();
            return user1;
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw e;
        }
    }

    public void deleteUser(Long id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            User user = entityManager.find(User.class, id);
            if (user != null) entityManager.remove(user);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw e;
        }
    }

    public User getUserById(Long userId) {
        return entityManager.find(User.class, userId);
    }

    public User getUserByUsername(String username) {
        try {
            TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
            query.setParameter("username", username);
            return query.getSingleResult();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }
}
