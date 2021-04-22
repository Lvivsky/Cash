package com.cash.service.impl;

import com.cash.util.singleton.SqliteConnection;
import com.cash.dao.User;
import com.cash.exception.UserNotFoundException;
import com.cash.service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    public User getUserById(Integer id) throws SQLException, ClassNotFoundException, UserNotFoundException {
        ResultSet resultSet = null;
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE Id = ?");
                ) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt("Id"),
                        resultSet.getString("Guid"),
                        resultSet.getString("Changed"),
                        resultSet.getString("Deleted"),
                        resultSet.getString("Login"));
            } else {
                throw new UserNotFoundException("No user with id : " + id);
            }

            connection.close();
            statement.close();
            resultSet.close();
            return user;
        } finally {
            if (resultSet != null)
                resultSet.close();
        }
    }

    @Override
    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        try (
                Connection connection = SqliteConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Users"))
        {
            while (resultSet.next())
            {
                users.add(
                        new User(
                            resultSet.getInt("Id"),
                            resultSet.getString("Guid"),
                            resultSet.getString("Changed"),
                            resultSet.getString("Deleted"),
                            resultSet.getString("Login")
                        )
                );
            }
            connection.close();
            statement.close();
            resultSet.close();
            return users;
        }
    }


}
