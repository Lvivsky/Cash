package com.cash.dao;

import com.cash.model.User;

import java.sql.SQLException;

public interface UserDao {

    User getUser() throws SQLException, ClassNotFoundException;
    void edit(User newUser) throws SQLException, ClassNotFoundException;
    void editUsername(String username) throws SQLException, ClassNotFoundException;

}
