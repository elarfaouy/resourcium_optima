package com.optima.resourcium_optima.controllers;

import com.optima.resourcium_optima.domain.entities.Department;
import com.optima.resourcium_optima.domain.entities.Role;
import com.optima.resourcium_optima.repositories.UserDao;
import com.optima.resourcium_optima.domain.entities.User;
import com.optima.resourcium_optima.util.AuthenticationUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String firstName = req.getParameter("name");
        String lastName = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        password = AuthenticationUtil.hashPassword(password);

        User user = new User(username, firstName, lastName, email, password, new Role(3L, "employee"), new Department(1L, "IT", "Info"));

        userDao.createUser(user);

        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
