package com.optima.resourcium_optima.controllers.equipment;

import com.optima.resourcium_optima.domain.entities.Equipment;
import com.optima.resourcium_optima.domain.entities.Reservation;
import com.optima.resourcium_optima.domain.entities.User;
import com.optima.resourcium_optima.domain.enums.EquipmentStatus;
import com.optima.resourcium_optima.repositories.EquipmentDao;
import com.optima.resourcium_optima.repositories.ReservationDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet(name = "EquipmentItemServlet", value = "equipment")
public class EquipmentItemServlet extends HttpServlet {
    private EquipmentDao equipmentDao;
    private ReservationDao reservationDao;

    @Override
    public void init() throws ServletException {
        equipmentDao = new EquipmentDao();
        reservationDao = new ReservationDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Equipment equipment = equipmentDao.getEquipmentById(id);

        req.setAttribute("equipment", equipment);

        req.getRequestDispatcher("WEB-INF/jsp/equipment/equipment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("_method");

        switch (action) {
            case "reserve":
                reserveEquipment(req, resp);
                break;
            case "notify":
                notifyEquipment(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public void reserveEquipment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = (User) req.getSession().getAttribute("user");
        long id = Long.parseLong(req.getParameter("id"));
        int days = Integer.parseInt(req.getParameter("days"));
        Date borrowDate = Date.valueOf(LocalDate.now());
        Date returnDate = Date.valueOf(LocalDate.now().plusDays(days));
        Equipment equipment = equipmentDao.getEquipmentById(id);

        Reservation reservation = new Reservation(borrowDate, returnDate, equipment, user);
        reservationDao.createReservation(reservation);

        equipment.setEquipmentStatus(EquipmentStatus.IN_USE);
        equipmentDao.updateEquipment(equipment);

        resp.sendRedirect(req.getContextPath() + "/reservations");
    }

    public void notifyEquipment(HttpServletRequest req, HttpServletResponse resp) {

    }
}
