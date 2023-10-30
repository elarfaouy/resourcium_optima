package com.optima.resourcium_optima.repositories;

import com.optima.resourcium_optima.domain.entities.Reservation;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ReservationDao {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("optima");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final EntityTransaction entityTransaction = entityManager.getTransaction();

    public void createReservation(Reservation reservation) {
        entityTransaction.begin();
        entityManager.persist(reservation);
        entityTransaction.commit();
    }

    public Reservation updateReservation(Reservation reservation) {
        entityTransaction.begin();
        Reservation reservation1 = entityManager.merge(reservation);
        entityTransaction.commit();
        return reservation1;
    }

    public void deleteReservation(Long id) {
        entityTransaction.begin();
        Reservation reservation = entityManager.find(Reservation.class, id);
        if (reservation != null) entityManager.remove(reservation);
        entityTransaction.commit();
    }

    public Reservation getReservationById(Long reservationId) {
        entityTransaction.begin();
        Reservation reservation = entityManager.find(Reservation.class, reservationId);
        entityTransaction.commit();
        return reservation;
    }

    public Reservation getLastReservationOfThatEquipment(long equipmentId) {
        entityTransaction.begin();
        TypedQuery<Reservation> query = entityManager.createQuery("SELECT e FROM Reservation e WHERE e.equipment.id = :id AND e.returnDate > current date", Reservation.class);
        query.setParameter("id", equipmentId);
        entityTransaction.commit();
        return query.getSingleResult();
    }

    public List<Reservation> getAllReservations() {
        entityTransaction.begin();
        TypedQuery<Reservation> query = entityManager.createQuery("SELECT e FROM Reservation e", Reservation.class);
        entityTransaction.commit();
        return query.getResultList();
    }
}
