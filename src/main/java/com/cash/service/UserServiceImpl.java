package com.cash.service;

import com.cash.dao.UserDao;
import com.cash.dao.UserDaoImpl;
import com.cash.util.singleton.SqliteConnection;
import com.cash.model.User;
import com.cash.exception.UserNotFoundException;
import com.cash.service.UserService;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            log.info("SQLException |" + e.getMessage());
        } catch (ClassNotFoundException e) {
            log.info("ClassNotFoundException | " + e.getMessage());
        }
    }


//    @Override
//    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
//        List<User> users = new ArrayList<>();
//        try (
//                Connection connection = SqliteConnection.getConnection();
//                Statement statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery("SELECT * FROM Users"))
//        {
//            while (resultSet.next())
//            {
//                users.add(
//                        new User(
//                            resultSet.getInt("Id"),
//                            resultSet.getString("Guid"),
//                            resultSet.getString("Changed"),
//                            resultSet.getString("Deleted"),
//                            resultSet.getString("Login")
//                        )
//                );
//            }
//            connection.close();
//            statement.close();
//            resultSet.close();
//            return users;
//        }
//    }


}
