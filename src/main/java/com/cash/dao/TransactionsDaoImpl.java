package com.cash.dao;

import com.cash.core.SqliteConnection;
import com.cash.model.Transactions;
import lombok.extern.log4j.Log4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class TransactionsDaoImpl implements TransactionsDao {

    @Override
    public List<Transactions> getAll() throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Transactions");
                ) {
            List<Transactions> transactions = new ArrayList<>();
            while (resultSet.next()) {
                transactions.add(new Transactions(
                        resultSet.getInt("Id"),
                        resultSet.getString("Guid"),
                        resultSet.getString("Changed"),
                        resultSet.getString("Deleted"),
                        resultSet.getString("Group"),
                        resultSet.getString("Position"),
                        resultSet.getString("BudgetDate"),
                        resultSet.getString("Executed"),
                        resultSet.getString("Locked"),
                        resultSet.getString("IncomeAccount"),
                        resultSet.getString("IncomeAmount"),
                        resultSet.getString("IncomeBalance"),
                        resultSet.getString("ExpenseAccount"),
                        resultSet.getString("ExpenseAmount"),
                        resultSet.getString("ExpenseBalance"),
                        resultSet.getString("Quantity"),
                        resultSet.getString("Comment"),
                        resultSet.getString("ExtraComment1"),
                        resultSet.getString("ExtraComment2"),
                        resultSet.getString("ExtraComment3"),
                        resultSet.getString("ExtraComment4"),
                        resultSet.getString("BudgetPeriodEnd")
                ));
            }
            return transactions;
        }
    }

    @Override
    public void add(Transactions transactions) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO 'Transactions' (" +
                                "Guid,Changed,Deleted,'Group',Position,BudgetDate,Executed,Locked," +
                                "IncomeAccount,IncomeAmount,IncomeBalance," +
                                "ExpenseAccount,ExpenseAmount,ExpenseBalance," +
                                "Quantity,Comment," +
                                "ExtraComment1,ExtraComment2,ExtraComment3,ExtraComment4," +
                                "BudgetPeriodEnd) " +
                                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")
                ) {
            statement.setString(1,transactions.getGuid());
            statement.setString(2,transactions.getChanged());
            statement.setString(3,transactions.getDeleted());
            statement.setString(4,transactions.getGroup());
            statement.setString(5,transactions.getPosition());
            statement.setString(6,transactions.getBudgetDate());
            statement.setString(7,transactions.getExecuted());
            statement.setString(8,transactions.getLocked());
            statement.setString(9,transactions.getIncomeAccount());
            statement.setString(10,transactions.getIncomeAmount());
            statement.setString(11,transactions.getIncomeBalance());
            statement.setString(12,transactions.getExpenseAccount());
            statement.setString(13,transactions.getExpenseAmount());
            statement.setString(14,transactions.getExpenseBalance());
            statement.setString(15,transactions.getQuantity());
            statement.setString(16,transactions.getComment());
            statement.setString(17,transactions.getExtraComment1());
            statement.setString(18,transactions.getExtraComment2());
            statement.setString(19,transactions.getExtraComment3());
            statement.setString(20,transactions.getExtraComment4());
            statement.setString(21,transactions.getBudgetPeriodEnd());
            statement.execute();
            log.info("TRANSACTION SUCCESS");
        }
    }

    @Override
    public void remove(int id) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE Transactions SET Deleted=0 where Id=?")
                ) {
            statement.setInt(1,id);
            statement.execute();
        }
    }

    @Override
    public Transactions getById(int id) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * from Transactions WHERE Id=? AND Deleted not like '1'")
                ) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            Transactions transactions = null;
            while (resultSet.next()) {
                transactions = new Transactions(
                        resultSet.getInt("Id"),
                        resultSet.getString("Guid"),
                        resultSet.getString("Changed"),
                        resultSet.getString("Deleted"),
                        resultSet.getString("Group"),
                        resultSet.getString("Position"),
                        resultSet.getString("BudgetDate"),
                        resultSet.getString("Executed"),
                        resultSet.getString("Locked"),
                        resultSet.getString("IncomeAccount"),
                        resultSet.getString("IncomeAmount"),
                        resultSet.getString("IncomeBalance"),
                        resultSet.getString("ExpenseAccount"),
                        resultSet.getString("ExpenseAmount"),
                        resultSet.getString("ExpenseBalance"),
                        resultSet.getString("Quantity"),
                        resultSet.getString("Comment"),
                        resultSet.getString("ExtraComment1"),
                        resultSet.getString("ExtraComment2"),
                        resultSet.getString("ExtraComment3"),
                        resultSet.getString("ExtraComment4"),
                        resultSet.getString("BudgetPeriodEnd"));
            }
            return transactions;
        }
    }

    @Override
    public List<Transactions> getByIncomeAccount(int id) throws SQLException, ClassNotFoundException {
        List<Transactions> transactionsList = new ArrayList<>();
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * from Transactions WHERE IncomeAccount like ?")
        ) {
            statement.setString(1,String.valueOf(id));

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                transactionsList.add(new Transactions(
                        resultSet.getInt("Id"),
                        resultSet.getString("Guid"),
                        resultSet.getString("Changed"),
                        resultSet.getString("Deleted"),
                        resultSet.getString("Group"),
                        resultSet.getString("Position"),
                        resultSet.getString("BudgetDate"),
                        resultSet.getString("Executed"),
                        resultSet.getString("Locked"),
                        resultSet.getString("IncomeAccount"),
                        resultSet.getString("IncomeAmount"),
                        resultSet.getString("IncomeBalance"),
                        resultSet.getString("ExpenseAccount"),
                        resultSet.getString("ExpenseAmount"),
                        resultSet.getString("ExpenseBalance"),
                        resultSet.getString("Quantity"),
                        resultSet.getString("Comment"),
                        resultSet.getString("ExtraComment1"),
                        resultSet.getString("ExtraComment2"),
                        resultSet.getString("ExtraComment3"),
                        resultSet.getString("ExtraComment4"),
                        resultSet.getString("BudgetPeriodEnd")));
            }
            return transactionsList;
        }
    }

    @Override
    public List<Transactions> getByExpenseAccount(int id) throws SQLException, ClassNotFoundException {
        List<Transactions> transactionsList = new ArrayList<>();
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * from Transactions WHERE ExpenseAccount like ?")
        ) {
            statement.setString(1,String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                transactionsList.add( new Transactions(
                        resultSet.getInt("Id"),
                        resultSet.getString("Guid"),
                        resultSet.getString("Changed"),
                        resultSet.getString("Deleted"),
                        resultSet.getString("Group"),
                        resultSet.getString("Position"),
                        resultSet.getString("BudgetDate"),
                        resultSet.getString("Executed"),
                        resultSet.getString("Locked"),
                        resultSet.getString("IncomeAccount"),
                        resultSet.getString("IncomeAmount"),
                        resultSet.getString("IncomeBalance"),
                        resultSet.getString("ExpenseAccount"),
                        resultSet.getString("ExpenseAmount"),
                        resultSet.getString("ExpenseBalance"),
                        resultSet.getString("Quantity"),
                        resultSet.getString("Comment"),
                        resultSet.getString("ExtraComment1"),
                        resultSet.getString("ExtraComment2"),
                        resultSet.getString("ExtraComment3"),
                        resultSet.getString("ExtraComment4"),
                        resultSet.getString("BudgetPeriodEnd")));
            }
            return transactionsList;
        }
    }

    @Override
    public int getIdByGuid(String guid) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT Id FROM Transactions WHERE Guid like ? AND Deleted not like '1'")
                ) {
            statement.setString(1, guid);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.getInt("Id");
        }
    }

}
