package com.cash.dao;

import com.cash.model.Accounts;
import com.cash.core.SqliteConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountsDaoImpl implements AccountsDao {

    private void close(Statement statement, Connection connection, ResultSet resultSet) throws SQLException {
        statement.close();
        connection.close();
        resultSet.close();
    }

    @Override
    public List<Accounts> getAll() throws SQLException, ClassNotFoundException {
        List<Accounts> accounts = new ArrayList<>();
        try (
                Connection connection = SqliteConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Accounts")
        ) {
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
            close(statement,connection,resultSet);
            return accounts;
        }
    }

}
