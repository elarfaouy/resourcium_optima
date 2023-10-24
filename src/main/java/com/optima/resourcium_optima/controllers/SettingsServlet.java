package com.optima.resourcium_optima.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SettingsServlet", value = "/settings")
public class SettingsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/settings.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("_method") != null ? req.getParameter("_method") : "";

        switch (action) {
            case "user":
                updateUserInfo(req, resp);
                break;
            case "password":
                updatePassword(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public void updateUserInfo(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
    }

    public void updatePassword(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
    }
}
