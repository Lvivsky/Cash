package com.cash.service.impl;

import com.cash.util.singleton.SqliteConnection;
import com.cash.dao.User;
import com.cash.exception.UserNotFoundException;
import com.cash.service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    public User getUserById(Integer id) throws SQLException, ClassNotFoundException, UserNotFoundException {
        ResultSet resultSet = null;
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE Id = ?");
                ) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("Id"),
                        resultSet.getString("Guid"),
                        resultSet.getString("Changed"),
                        resultSet.getString("Deleted"),
                        resultSet.getString("Login"));
            } else {
                throw new UserNotFoundException("No blog with id : " + id);
            }
        } finally {
            if (resultSet != null)
            {
                resultSet.close();
            }
        }
    }



}
