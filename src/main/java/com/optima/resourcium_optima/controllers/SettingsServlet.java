package com.optima.resourcium_optima.controllers;

import com.optima.resourcium_optima.domain.entities.User;
import com.optima.resourcium_optima.repositories.UserDao;
import com.optima.resourcium_optima.services.UserService;
import com.optima.resourcium_optima.util.AuthenticationUtil;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SettingsServlet", value = "/settings")
public class SettingsServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/settings.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("_method");

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

    public void updateUserInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");

        User user = userService.getUserById(id);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);

        userService.updateUser(user);

        req.getSession().setAttribute("user", user);

        resp.sendRedirect(req.getContextPath() + "/settings");
    }

    public void updatePassword(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        String oldPassword = req.getParameter("currentPassword");
        String newPassword = req.getParameter("newPassword");

        User user = userService.getUserById(id);

        userService.updateUserPassword(user, oldPassword, newPassword);

        resp.sendRedirect(req.getContextPath() + "/settings");
    }
}
