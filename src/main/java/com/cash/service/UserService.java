package com.cash.service;

import com.cash.dao.User;
import com.cash.exception.UserNotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    User getUserById(Integer id) throws SQLException, ClassNotFoundException, UserNotFoundException;
    List<User> getAllUsers() throws SQLException, ClassNotFoundException;


}
