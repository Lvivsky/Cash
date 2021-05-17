package com.cash.dao;

import com.cash.model.TransactionCategories;

import java.sql.SQLException;

public interface TransactionCategoriesDao {

    void add(TransactionCategories transactionCategories) throws SQLException, ClassNotFoundException;
    TransactionCategories get(int id) throws SQLException, ClassNotFoundException;
}
