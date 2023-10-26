package com.optima.resourcium_optima.domain.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date borrowDate;
    private Date returnDate;
    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Reservation() {
    }

    public Reservation(Date borrowDate, Date returnDate, Equipment equipment, User user) {
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.equipment = equipment;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
