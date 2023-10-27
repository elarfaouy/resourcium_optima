package com.optima.resourcium_optima.services;

import com.optima.resourcium_optima.domain.entities.User;
import com.optima.resourcium_optima.repositories.UserDao;
import com.optima.resourcium_optima.util.AuthenticationUtil;

public class UserService {
    private final UserDao userDao = new UserDao();

    public void createUser(User user) {
        try {
            userDao.createUser(user);
        } catch (RuntimeException e) {
            throw new RuntimeException("error when create user !.");
        }
    }

    public User updateUser(User user) {
        User updated = userDao.updateUser(user);
        if (updated != null) {
            return updated;
        } else {
            throw new RuntimeException("error when update user !.");
        }
    }

    public User getUserById(long userId) {
        return userDao.getUserById(userId);
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public void updateUserPassword(User user, String oldPassword, String newPassword){
        boolean verifyPassword = AuthenticationUtil.verifyPassword(oldPassword, user.getPassword());

        if (verifyPassword) {
            user.setPassword(AuthenticationUtil.hashPassword(newPassword));
            this.updateUser(user);
        }
    }
}
