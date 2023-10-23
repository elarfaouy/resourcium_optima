package com.optima.resourcium_optima.repositories;

import com.optima.resourcium_optima.domain.entities.Equipment;
import com.optima.resourcium_optima.domain.entities.User;
import jakarta.persistence.*;

import java.util.List;

public class EquipmentDao {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("optima");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final EntityTransaction entityTransaction = entityManager.getTransaction();

    public void createEquipment(Equipment equipment) {
        entityTransaction.begin();
        entityManager.persist(equipment);
        entityTransaction.commit();
    }

    public Equipment updateEquipment(Equipment equipment) {
        entityTransaction.begin();
        Equipment equipment1 = entityManager.merge(equipment);
        entityTransaction.commit();
        return equipment1;
    }

    public void deleteEquipment(Long id) {
        entityTransaction.begin();
        Equipment equipment = entityManager.find(Equipment.class, id);
        if (equipment != null) entityManager.remove(equipment);
        entityTransaction.commit();
    }

    public Equipment getEquipmentById(Long equipmentId) {
        entityTransaction.begin();
        Equipment equipment = entityManager.find(Equipment.class, equipmentId);
        entityTransaction.commit();
        return equipment;
    }

    public List<Equipment> getAllEquipments(String search) {
        entityTransaction.begin();
        TypedQuery<Equipment> query = entityManager.createQuery("SELECT e FROM Equipment e WHERE e.name like :search", Equipment.class);
        query.setParameter("search", "%"+search+"%");
        entityTransaction.commit();
        return query.getResultList();
    }
}
