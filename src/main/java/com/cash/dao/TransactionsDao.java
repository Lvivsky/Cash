package com.cash.dao;

import com.cash.model.Transactions;

import java.sql.SQLException;
import java.util.List;

public interface TransactionsDao {

    List<Transactions> getAll() throws SQLException, ClassNotFoundException;

    void add(Transactions transactions) throws SQLException, ClassNotFoundException;
    void remove(int id) throws SQLException, ClassNotFoundException;

    Transactions getById(int id) throws SQLException, ClassNotFoundException;
    List<Transactions> getByIncomeAccount(int id) throws SQLException, ClassNotFoundException;
    List<Transactions> getByExpenseAccount(int id) throws SQLException, ClassNotFoundException;

    int getIdByGuid(String guid) throws SQLException, ClassNotFoundException;
}
