package com.optima.resourcium_optima.services;

import com.optima.resourcium_optima.domain.entities.Equipment;
import com.optima.resourcium_optima.domain.entities.Reservation;
import com.optima.resourcium_optima.domain.entities.User;
import com.optima.resourcium_optima.domain.enums.EquipmentStatus;
import com.optima.resourcium_optima.repositories.ReservationDao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ReservationService {
    private final ReservationDao reservationDao = new ReservationDao();
    private final EquipmentService equipmentService = new EquipmentService();

    public void createReservation(Reservation reservation) {
        try {
            reservationDao.createReservation(reservation);
        } catch (RuntimeException e) {
            throw new RuntimeException("error when create reservation !");
        }
    }

    public Reservation updateReservation(Reservation reservation) {
        Reservation updated = reservationDao.updateReservation(reservation);
        if (updated != null) {
            return updated;
        } else {
            throw new RuntimeException("error when update reservation !.");
        }
    }

    public Reservation getReservationById(long reservationId) {
        return reservationDao.getReservationById(reservationId);
    }

    public Reservation getLastReservationOfThatEquipment(long equipmentId) {
        return reservationDao.getLastReservationOfThatEquipment(equipmentId);
    }

    public List<Reservation> getAllReservations() {
        return reservationDao.getAllReservations();
    }

    public void reserveEquipment(User user, Equipment equipment, int days) {
        Date borrowDate = Date.valueOf(LocalDate.now());
        Date returnDate = Date.valueOf(LocalDate.now().plusDays(days));

        Reservation reservation = new Reservation(borrowDate, returnDate, equipment, user);
        this.createReservation(reservation);

        equipment.setEquipmentStatus(EquipmentStatus.IN_USE);
        equipmentService.updateEquipment(equipment);
    }

    public void returnEquipment(long reservationId) {
        Reservation reservation = this.getReservationById(reservationId);
        Date newDate = Date.valueOf(LocalDate.now());
        reservation.setReturnDate(newDate);

        this.updateReservation(reservation);

        Equipment equipment = reservation.getEquipment();
        equipment.setEquipmentStatus(EquipmentStatus.AVAILABLE);
        equipmentService.updateEquipment(equipment);
    }
}
