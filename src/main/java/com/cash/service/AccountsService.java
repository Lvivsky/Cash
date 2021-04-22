package com.cash.service;

import com.cash.dao.Accounts;

import java.sql.SQLException;
import java.util.List;

public interface AccountsService {

    List<Accounts> getAllAccounts() throws SQLException, ClassNotFoundException;
}
