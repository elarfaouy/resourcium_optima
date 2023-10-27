package com.optima.resourcium_optima.controllers;

import com.optima.resourcium_optima.domain.entities.Equipment;
import com.optima.resourcium_optima.services.EquipmentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EquipmentTableServlet", value = "/equipments-table")
public class EquipmentTableServlet extends HttpServlet {
    private final EquipmentService equipmentService = new EquipmentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Equipment> list = equipmentService.getAllEquipments(req.getParameter("search"));
        req.setAttribute("list", list);
        req.getRequestDispatcher("WEB-INF/jsp/equips-table.jsp").forward(req, resp);
    }
}
