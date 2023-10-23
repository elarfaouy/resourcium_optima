package com.optima.resourcium_optima.controllers;

import com.optima.resourcium_optima.domain.entities.Department;
import com.optima.resourcium_optima.domain.entities.Equipment;
import com.optima.resourcium_optima.domain.enums.EquipmentStatus;
import com.optima.resourcium_optima.repositories.EquipmentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EquipmentServlet", value = "/equipments")
public class EquipmentServlet extends HttpServlet {
    private EquipmentDao equipmentDao;

    @Override
    public void init() throws ServletException {
        equipmentDao = new EquipmentDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/equipments.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        EquipmentStatus status = EquipmentStatus.valueOf(req.getParameter("status"));
        long departmentId = Long.parseLong(req.getParameter("department"));

        Equipment equipment = new Equipment(name, type, status, new Department(departmentId, "", ""));

        equipmentDao.createEquipment(equipment);

        resp.sendRedirect(req.getContextPath() + "/equips-table");
    }
}
