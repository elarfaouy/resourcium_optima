package com.optima.resourcium_optima.controllers;

import com.optima.resourcium_optima.domain.entities.Issue;
import com.optima.resourcium_optima.repositories.IssueDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "IssueServlet", value = "/issues")
public class IssueServlet extends HttpServlet {
    private IssueDao issueDao;

    @Override
    public void init() throws ServletException {
        issueDao = new IssueDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Issue> issues = issueDao.getAllIssues();
        req.setAttribute("issues", issues);
        req.getRequestDispatcher("WEB-INF/jsp/issues.jsp").forward(req, resp);
    }
}
