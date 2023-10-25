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
import java.util.List;

@WebServlet(name = "EquipmentServlet", value = "/equipments")
public class EquipmentServlet extends HttpServlet {
    private EquipmentDao equipmentDao;

    @Override
    public void init() throws ServletException {
        equipmentDao = new EquipmentDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search") != null ? req.getParameter("search") : "";
        List<Equipment> list = equipmentDao.getAllEquipments(search);
        req.setAttribute("list", list);
        req.getRequestDispatcher("WEB-INF/jsp/equipments.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("_method");

        switch (action) {
            case "add":
                addEquipment(req, resp);
                break;
            case "update":
                updateEquipment(req, resp);
                break;
            case "delete":
                deleteEquipment(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public void addEquipment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        EquipmentStatus status = EquipmentStatus.valueOf(req.getParameter("status"));
        long departmentId = Long.parseLong(req.getParameter("department"));

        Equipment equipment = new Equipment(name, type, status, new Department(departmentId, "", ""));

        equipmentDao.createEquipment(equipment);

        resp.sendRedirect(req.getContextPath() + "/equipments-table");
    }

    public void updateEquipment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long equipmentId = Long.parseLong(req.getParameter("id"));

        Equipment equipment = equipmentDao.getEquipmentById(equipmentId);

        if (equipment == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String name = req.getParameter("name");
        String type = req.getParameter("type");
        EquipmentStatus status = EquipmentStatus.valueOf(req.getParameter("status"));
        Long departmentId = Long.parseLong(req.getParameter("department"));

        equipment.setName(name);
        equipment.setType(type);
        equipment.setEquipmentStatus(status);
        equipment.setDepartment(new Department(departmentId, "", ""));

        equipmentDao.updateEquipment(equipment);

        resp.sendRedirect(req.getContextPath() + "/equipments-table");
    }

    public void deleteEquipment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long equipmentId = Long.parseLong(req.getParameter("id"));
        equipmentDao.deleteEquipment(equipmentId);
        resp.sendRedirect(req.getContextPath() + "/equipments-table");
    }
}
