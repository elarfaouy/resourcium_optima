package com.optima.resourcium_optima.repositories;

import com.optima.resourcium_optima.domain.entities.Issue;
import jakarta.persistence.*;

import java.util.List;

public class IssueDao {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("optima");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final EntityTransaction entityTransaction = entityManager.getTransaction();

    public void createIssue(Issue issue) {
        entityTransaction.begin();
        entityManager.persist(issue);
        entityTransaction.commit();
    }

    public List<Issue> getAllIssues() {
        entityTransaction.begin();
        TypedQuery<Issue> query = entityManager.createQuery("SELECT e FROM Issue e", Issue.class);
        entityTransaction.commit();
        return query.getResultList();
    }
}
