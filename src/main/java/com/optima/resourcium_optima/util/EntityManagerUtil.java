package com.optima.resourcium_optima.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
