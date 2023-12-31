package com.optima.resourcium_optima.controllers;

import com.optima.resourcium_optima.domain.entities.Reservation;
import com.optima.resourcium_optima.services.ReservationService;
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
    private final ReservationService reservationService = new ReservationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Reservation> reservations = reservationService.getAllReservations();
        req.setAttribute("reservations", reservations);
        req.setAttribute("now", Date.valueOf(LocalDate.now()));
        req.getRequestDispatcher("WEB-INF/jsp/reservations.jsp").forward(req, resp);
    }
}
