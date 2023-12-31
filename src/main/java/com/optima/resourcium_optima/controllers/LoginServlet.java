package com.optima.resourcium_optima.controllers;

import com.optima.resourcium_optima.domain.entities.User;
import com.optima.resourcium_optima.services.UserService;
import com.optima.resourcium_optima.util.AuthenticationUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.getUserByUsername(username);

        if (user != null && AuthenticationUtil.verifyPassword(password, user.getPassword())) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/equipments");
        } else {
            // todo : send error message
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
