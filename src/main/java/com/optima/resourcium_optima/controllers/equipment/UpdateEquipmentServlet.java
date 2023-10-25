package com.optima.resourcium_optima.controllers.equipment;

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

@WebServlet(value = "/update-equipment")
public class UpdateEquipmentServlet extends HttpServlet {
    private EquipmentDao equipmentDao;

    @Override
    public void init() throws ServletException {
        equipmentDao = new EquipmentDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Equipment equipment = equipmentDao.getEquipmentById(id);
        req.setAttribute("equipment", equipment);
        req.getRequestDispatcher("WEB-INF/jsp/equipment/update-equipment.jsp").forward(req, resp);
    }
}
