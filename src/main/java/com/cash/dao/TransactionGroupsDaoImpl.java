package com.cash.dao;

import com.cash.core.SqliteConnection;
import com.cash.model.TransactionGroups;
import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j
public class TransactionGroupsDaoImpl implements TransactionGroupsDao {

    @Override
    public void add(TransactionGroups transactionGroups) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO TransactionGroups " +
                                "(Guid,Changed,Deleted,HolderDateTime,Position,Recurrence) " +
                                "VALUES (?,?,?,?,?,?)")
                ) {
            statement.setString(1,transactionGroups.getGuid());
            statement.setString(2,transactionGroups.getChanged());
            statement.setString(3,transactionGroups.getDeleted());
            statement.setString(4,transactionGroups.getHolderDateTime());
            statement.setString(5,transactionGroups.getPosition());
            statement.setString(6,transactionGroups.getRecurrence());
            statement.execute();
        }
    }

    @Override
    public int getIdByGuid(String guid) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "Select Id FROM TransactionGroups WHERE Guid like ?")
                ) {
            statement.setString(1, guid);
            ResultSet resultSet = statement.executeQuery();
            return Integer.parseInt(resultSet.getString("Id"));
        }
    }


}
