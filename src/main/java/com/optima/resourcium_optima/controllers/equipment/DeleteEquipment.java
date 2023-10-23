package com.optima.resourcium_optima.controllers.equipment;

import com.optima.resourcium_optima.repositories.EquipmentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/delete-equipment")
public class DeleteEquipment extends HttpServlet {
    private EquipmentDao equipmentDao;

    @Override
    public void init() throws ServletException {
        equipmentDao = new EquipmentDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long equipmentId = Long.parseLong(req.getParameter("id"));
        equipmentDao.deleteEquipment(equipmentId);
        resp.sendRedirect(req.getContextPath() + "/equipments-table");    }
}
