package com.optima.resourcium_optima.repositories;

import com.optima.resourcium_optima.domain.UpdatedReservation;
import com.optima.resourcium_optima.domain.entities.Reservation;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationDao {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("optima");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final EntityTransaction entityTransaction = entityManager.getTransaction();

    public List<UpdatedReservation> customUpdateReservation(String type, Date dateNow) {
        List<UpdatedReservation> reservations = new ArrayList<>();
        entityTransaction.begin();
        TypedQuery<Reservation> query = entityManager.createQuery("select r from Reservation r " +
                "WHERE r.equipment.type = :eq_type  and r.returnDate > :r_date", Reservation.class);
        query.setParameter("eq_type", type);
        query.setParameter("r_date", dateNow);
        List<Reservation> list = query.getResultList();
        entityTransaction.commit();

        list.forEach(e -> {
            long size = e.getEquipment().getName().length();
            Date newDate = Date.valueOf(e.getReturnDate().toLocalDate().plusDays(size));

            e.setReturnDate(newDate);

            entityTransaction.begin();
            entityManager.merge(e);
            entityTransaction.commit();

            UpdatedReservation reservation = new UpdatedReservation(e.getId(), newDate);
            reservations.add(reservation);
        });

        return reservations;
    }
}
