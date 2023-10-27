package com.optima.resourcium_optima.controllers.equipment;

import com.optima.resourcium_optima.domain.entities.*;
import com.optima.resourcium_optima.domain.enums.EquipmentStatus;
import com.optima.resourcium_optima.domain.enums.IssueStatus;
import com.optima.resourcium_optima.repositories.IssueDao;
import com.optima.resourcium_optima.repositories.NotificationDao;
import com.optima.resourcium_optima.services.EquipmentService;
import com.optima.resourcium_optima.services.ReservationService;
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
    private NotificationDao notificationDao;
    private IssueDao issueDao;
    private final EquipmentService equipmentService = new EquipmentService();
    private final ReservationService reservationService = new ReservationService();

    @Override
    public void init() throws ServletException {
        notificationDao = new NotificationDao();
        issueDao = new IssueDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Equipment equipment = equipmentService.getEquipmentById(id);

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
            case "return":
                returnEquipment(req, resp);
                break;
            case "report":
                reportEquipment(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public void reserveEquipment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = (User) req.getSession().getAttribute("user");
        long id = Long.parseLong(req.getParameter("id"));
        Equipment equipment = equipmentService.getEquipmentById(id);
        int days = Integer.parseInt(req.getParameter("days"));

        reservationService.reserveEquipment(user, equipment, days);

        resp.sendRedirect(req.getContextPath() + "/reservations");
    }

    public void notifyEquipment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = (User) req.getSession().getAttribute("user");
        long id = Long.parseLong(req.getParameter("id"));
        Equipment equipment = equipmentService.getEquipmentById(id);
        String message = "hello " + user.getUsername() + ", i would like to inform you that the : " + equipment.getName() + " is now available.";
        Date notifyDate = reservationService.getLastReservationOfThatEquipment(id).getReturnDate();

        Notification notification = new Notification(notifyDate, message, user, equipment);

        notificationDao.createNotification(notification);

        resp.sendRedirect(req.getContextPath() + "/equipments");
    }

    public void returnEquipment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));

        reservationService.returnEquipment(id);

        resp.sendRedirect(req.getContextPath() + "/reservations");
    }

    public void reportEquipment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = (User) req.getSession().getAttribute("user");
        long id = Long.parseLong(req.getParameter("id"));
        Equipment equipment = equipmentService.getEquipmentById(id);
        Date reportDate = Date.valueOf(LocalDate.now());

        Issue issue = new Issue(reportDate, IssueStatus.IN_PROGRESS, user, equipment);

        issueDao.createIssue(issue);

        resp.sendRedirect(req.getContextPath() + "/reservations");
    }
}
