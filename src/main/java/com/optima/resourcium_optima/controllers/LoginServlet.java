package com.optima.resourcium_optima.controllers;

import com.optima.resourcium_optima.repositories.UserDao;
import com.optima.resourcium_optima.entities.User;
import com.optima.resourcium_optima.util.AuthenticationUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userDao.getUserByUsername(username);

        if (user != null && AuthenticationUtil.verifyPassword(password, user.getPassword())) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/dashboard.jsp");
        } else {
            // todo : send error message
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}
