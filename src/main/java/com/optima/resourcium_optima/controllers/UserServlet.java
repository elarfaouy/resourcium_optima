package com.optima.resourcium_optima.controllers;

import com.optima.resourcium_optima.dao.UserDao;
import com.optima.resourcium_optima.entities.User;
import com.optima.resourcium_optima.util.AuthenticationUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/user/*")
public class UserServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo() == null ? "" : req.getPathInfo();
        switch (action) {
            case "/register":
                resp.sendRedirect(req.getContextPath() + "/register.jsp");
                break;
            case "/login":
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo() == null ? "" : req.getPathInfo();
        switch (action) {
            case "/register":
                handleRegistration(req, resp);
                break;
            case "/login":
                handleLogin(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void handleRegistration(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String firstName = req.getParameter("name");
        String lastName = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        password = AuthenticationUtil.hashPassword(password);

        User user = new User(username, firstName, lastName, email, password, role);

        userDao.createUser(user);

        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }

    private void handleLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userDao.getUserByUsername(username);

        if (user != null && AuthenticationUtil.verifyPassword(password, user.getPassword())) {
            req.getSession().setAttribute("loggedInUser", user);
            resp.sendRedirect(req.getContextPath() + "/dashboard.jsp");
        } else {
            // todo : send error message
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}
