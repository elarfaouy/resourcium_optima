package com.optima.resourcium_optima.filters;


import com.optima.resourcium_optima.domain.entities.Notification;
import com.optima.resourcium_optima.domain.entities.User;
import com.optima.resourcium_optima.repositories.NotificationDao;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.ocpsoft.prettytime.PrettyTime;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebFilter(urlPatterns = {"/equipments", "/equipments-table", "/reservations", "/tasks", "/issues", "/settings"})
public class NotificationFilter implements Filter {
    private final NotificationDao notificationDao = new NotificationDao();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrettyTime prettyTime = new PrettyTime();
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        User user = (User) req.getSession().getAttribute("user");

        List<Notification> notifications = notificationDao.getNotificationsByUser(user.getId());

        notifications.forEach(e -> {
            e.setFormatDate(prettyTime.format(e.getNotifyDate()));
        });

        servletRequest.setAttribute("notifications", notifications);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
