package com.cash.dao;

import com.cash.model.User;
import com.cash.util.singleton.SqliteConnection;
import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j
public class UserDaoImpl implements UserDao {

    @Override
    public User getUser() throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE Id = ?");
        ) {
            statement.setInt(1, 1);
            ResultSet resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt("Id"),
                        resultSet.getString("Guid"),
                        resultSet.getString("Changed"),
                        resultSet.getString("Deleted"),
                        resultSet.getString("Login"));
            }
            connection.close();
            statement.close();
            resultSet.close();
            log.info("Get user info");
            return user;
        }
    }

    @Override
    public void edit(User newUser) throws SQLException, ClassNotFoundException {
        log.info("Edit functional is not finished!");
        // TODO:: UserDaoImpl add edit functional
    }
}
