package com.cash.dao;

import com.cash.model.TransactionGroups;

import java.sql.SQLException;

public interface TransactionGroupsDao {

    void add(TransactionGroups transactionGroups) throws SQLException, ClassNotFoundException;
    int getIdByGuid(String guid) throws SQLException, ClassNotFoundException;

}
