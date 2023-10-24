package com.optima.resourcium_optima.controllers;

import com.optima.resourcium_optima.domain.UpdatedReservation;
import com.optima.resourcium_optima.domain.entities.Reservation;
import com.optima.resourcium_optima.repositories.ReservationDao;
import jakarta.persistence.*;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "ReservationServlet", value = "/reservations")
public class ReservationServlet extends HttpServlet {
    private ReservationDao reservationDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        reservationDao = new ReservationDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = "one";
        Date dateNow = Date.valueOf(LocalDate.now());

        List<UpdatedReservation> listReservationUpdated = reservationDao.customUpdateReservation(type, dateNow);

        req.getRequestDispatcher("WEB-INF/jsp/reservations.jsp").forward(req, resp);
    }
}
