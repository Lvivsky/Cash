package com.cash.dao;

import com.cash.model.Accounts;

import java.sql.SQLException;
import java.util.List;

public interface AccountsDao {

    List<Accounts> getAll() throws SQLException, ClassNotFoundException;

}
