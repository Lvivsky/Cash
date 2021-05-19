package com.cash.dao;

import com.cash.model.TransactionCategories;

import java.sql.SQLException;
import java.util.List;

public interface TransactionCategoriesDao {

    void add(TransactionCategories transactionCategories) throws SQLException, ClassNotFoundException;
    TransactionCategories get(int id) throws SQLException, ClassNotFoundException;


    TransactionCategories getByCategoryId(String id) throws SQLException, ClassNotFoundException;
    TransactionCategories getByTransactionId(String id) throws SQLException, ClassNotFoundException;


}
