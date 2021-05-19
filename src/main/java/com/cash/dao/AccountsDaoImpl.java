package com.cash.dao;

import com.cash.model.Accounts;
import com.cash.core.SqliteConnection;
import com.cash.model.Transactions;

import java.sql.*;
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
                ResultSet resultSet = statement.executeQuery(
                        "SELECT * FROM Accounts WHERE Deleted=0")
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

    @Override
    public List<Accounts> getAllNotLocked() throws SQLException, ClassNotFoundException {
        List<Accounts> accounts = new ArrayList<>();
        try (
                Connection connection = SqliteConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "SELECT * FROM Accounts WHERE Deleted=0 AND Locked=0")
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

    @Override
    public Accounts getAccounts(int id) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM Accounts WHERE Id=? AND Deleted=0")
                ) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            Accounts accounts = new Accounts();
            while (resultSet.next()) {
                accounts.setId(resultSet.getInt("Id"));
                accounts.setGuid(resultSet.getString("Guid"));
                accounts.setChanged(resultSet.getString("Changed"));
                accounts.setDeleted(resultSet.getString("Deleted"));
                accounts.setName(resultSet.getString("Name"));
                accounts.setStartingBalance(resultSet.getString("StartingBalance"));
                accounts.setCurrency(resultSet.getString("Currency"));
                accounts.setComment(resultSet.getString("Comment"));
                accounts.setLocked(resultSet.getString("Locked"));
            }
            return accounts;
        }
    }

    @Override
    public void setLocked(int id, int locked) throws SQLException, ClassNotFoundException {
        if (locked == 0 || locked == 1)
            try (
                    Connection connection = SqliteConnection.getConnection();
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE Accounts SET Locked=? WHERE Id = ?")
                    ) {
                statement.setInt(1,locked);
                statement.setInt(2,id);
                statement.execute();
            }
    }

    @Override
    public void deleteAccount(int id) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE Accounts SET Deleted=1 WHERE Id = ?")
        ) {
            statement.setInt(1,id);
            statement.execute();
        }
    }

    @Override
    public void edit(Accounts accounts) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE Accounts SET Changed=?, Name=?, StartingBalance=?, Comment=?, Currency=? WHERE Id=?")
                ) {
            statement.setString(1,accounts.getChanged());
            statement.setString(2,accounts.getName());
            statement.setString(3,accounts.getStartingBalance());
            statement.setString(4,accounts.getComment());
            statement.setString(5,accounts.getCurrency());
            statement.setInt(6,accounts.getId());
            statement.execute();
        }
    }

    @Override
    public void add(Accounts accounts) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO Accounts " +
                                "(Guid,Changed,Deleted,'Name',StartingBalance,Currency,Comment,Locked)" +
                                "VALUES (?,?,?,?,?,?,?,?)")
                ) {
            statement.setString(1,accounts.getGuid());
            statement.setString(2,accounts.getChanged());
            statement.setString(3,accounts.getDeleted());
            statement.setString(4,accounts.getName());
            statement.setString(5,accounts.getStartingBalance());
            statement.setString(6,accounts.getCurrency());
            statement.setString(7,accounts.getComment());
            statement.setString(8, accounts.getLocked());
            statement.execute();
        }
    }

}
