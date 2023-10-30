package com.optima.resourcium_optima.repositories;

import com.optima.resourcium_optima.domain.entities.Notification;
import jakarta.persistence.*;

import java.util.List;

public class NotificationDao {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("optima");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final EntityTransaction entityTransaction = entityManager.getTransaction();

    public void createNotification(Notification notification) {
        entityTransaction.begin();
        entityManager.persist(notification);
        entityTransaction.commit();
    }

    public List<Notification> getNotificationsByUser(long user_id) {
        entityTransaction.begin();
        TypedQuery<Notification> query = entityManager.createQuery("SELECT n FROM Notification n " +
                "WHERE n.user.id = :user_id " +
                "AND n.notifyDate <= current date " +
                "ORDER BY n.notifyDate DESC " +
                "LIMIT 3", Notification.class);
        query.setParameter("user_id", user_id);
        entityTransaction.commit();
        return query.getResultList();
    }
}
