package com.cash.dao;

import com.cash.core.SqliteConnection;
import com.cash.model.TransactionCategories;
import lombok.extern.log4j.Log4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class TransactionCategoriesDaoImpl implements TransactionCategoriesDao {

    @Override
    public void add(TransactionCategories transactionCategories) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO TransactionCategories ('Guid',Changed,Deleted,Category,'Transaction') " +
                                "VALUES (?,?,?,?,?)")
                ) {
            statement.setString(1,transactionCategories.getGuid());
            statement.setString(2,transactionCategories.getChanged());
            statement.setString(3,transactionCategories.getDeleted());
            statement.setString(4,transactionCategories.getCategory());
            statement.setString(5,transactionCategories.getTransaction());
            statement.execute();
        }
    }

    @Override
    public TransactionCategories get(int id) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "Select * from TransactionCategories WHERE Id=?")
                ) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            TransactionCategories transactionCategories = new TransactionCategories();
            while (resultSet.next()) {
                transactionCategories.setId(resultSet.getInt("Id"));
                transactionCategories.setGuid(resultSet.getString("Guid"));
                transactionCategories.setChanged(resultSet.getString("Changed"));
                transactionCategories.setDeleted(resultSet.getString("Deleted"));
                transactionCategories.setCategory(resultSet.getString("Category"));
                transactionCategories.setTransaction(resultSet.getString("Transaction"));
            }
            return transactionCategories;
        }
    }

    @Override
    public TransactionCategories getByCategoryId(String id) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * from TransactionCategories WHERE Category LIKE ?")
                ) {
            statement.setString(1,id);

            TransactionCategories transactionCategories = new TransactionCategories();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                transactionCategories =
                        new TransactionCategories(
                                resultSet.getInt("Id"),
                                resultSet.getString("Guid"),
                                resultSet.getString("Changed"),
                                resultSet.getString("Deleted"),
                                resultSet.getString("Category"),
                                resultSet.getString("Transaction")
                );
            }
            return transactionCategories;
        }
    }

    @Override
    public TransactionCategories getByTransactionId(String id) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * from TransactionCategories WHERE \"Transaction\" LIKE ?")
        ) {
            statement.setString(1,id);

            TransactionCategories transactionCategories = new TransactionCategories();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                transactionCategories =
                        new TransactionCategories(
                                resultSet.getInt("Id"),
                                resultSet.getString("Guid"),
                                resultSet.getString("Changed"),
                                resultSet.getString("Deleted"),
                                resultSet.getString("Category"),
                                resultSet.getString("Transaction")
                        );
            }
            return transactionCategories;
        }
    }
}
