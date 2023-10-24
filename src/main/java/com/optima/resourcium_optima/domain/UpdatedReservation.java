package com.optima.resourcium_optima.domain;

import java.sql.Date;

public class UpdatedReservation {
    private long id;
    private Date date;

    public UpdatedReservation() {
    }

    public UpdatedReservation(long id, Date date) {
        this.id = id;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
