package com.cash.service.impl;

import com.cash.dao.Accounts;
import com.cash.service.AccountsService;
import com.cash.util.singleton.SqliteConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountsService {

    @Override
    public List<Accounts> getAllAccounts() throws SQLException, ClassNotFoundException {
        List<Accounts> accounts = new ArrayList<>();
        try (
                Connection connection = SqliteConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Accounts"))
        {
            while (resultSet.next())
            {
                accounts.add(
                        new Accounts(
                                resultSet.getInt("Id"),
                                resultSet.getString("Guid"),
                                resultSet.getString("Changed"),
                                resultSet.getString("Deleted"),
                                resultSet.getString("Name"),
                                resultSet.getString("StartingBalance"),
                                resultSet.getString("Currency"),
                                resultSet.getString("Comment"),
                                resultSet.getString("Locked")
                        )
                );
            }
            statement.close();
            connection.close();
            resultSet.close();
            return accounts;
        }
    }
}
