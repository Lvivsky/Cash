package com.cash.service;

import com.cash.dao.UserDao;
import com.cash.dao.UserDaoImpl;
import com.cash.model.User;
import lombok.extern.log4j.Log4j;

import java.sql.*;

@Log4j
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public User getUser() {
        try {
            return userDao.getUser();
        } catch (SQLException e) {
            log.info("SQLException |" + e.getMessage());
            return new User();
        } catch (ClassNotFoundException e) {
            log.info("ClassNotFoundException | " + e.getMessage());
            return new User();
        }
    }

    @Override
    public void edit(User newUser) {
        try {
            userDao.edit(newUser);
        } catch (SQLException e) {
            log.error("SQLException |" + e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
        }
    }

    @Override
    public void editUsername(String username) {
        try {
            userDao.editUsername(username);
        } catch (SQLException e) {
            log.error("SQLException |" + e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
        }
    }

}
