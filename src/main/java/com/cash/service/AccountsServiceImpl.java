package com.cash.service;

import com.cash.dao.AccountsDao;
import com.cash.dao.AccountsDaoImpl;
import com.cash.model.Accounts;
import com.cash.model.Currencies;
import lombok.extern.log4j.Log4j;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class AccountsServiceImpl implements AccountsService {

    private final AccountsDao accountsDao;
    private CurrenciesService currenciesService;

    public AccountsServiceImpl() {
        this.accountsDao = new AccountsDaoImpl();
        currenciesService = new CurrenciesServiceImpl();
    }

    @Override
    public List<Accounts> getAllAccounts() {
        try {
            return accountsDao.getAll();
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
            return new ArrayList<>();
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public List<Accounts> getAllAccountsWithCurrencyCode() {
        try {
            List<Accounts> acc = accountsDao.getAll();
            acc.forEach(curr -> {
                Currencies currencies = currenciesService.getById(Integer.parseInt(curr.getCurrency()));
                curr.setCurrency(currencies.getCode());
            });
            return acc;
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
            return new ArrayList<>();
        } catch (ClassNotFoundException e) {
            log.error("SQLException | " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Accounts getAccounts(int id) {
        try {
            return accountsDao.getAccounts(id);
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
            return new Accounts();
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
            return new Accounts();
        }
    }

    @Override
    public boolean isLocked(int id) {
        try {
            return accountsDao.getAccounts(id).getLocked().equals("1");
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
            return false;
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
            return false;
        }
    }

    @Override
    public void setLocked(int id, int locked) {
        try {
            accountsDao.setLocked(id,locked);
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
        }
    }

    @Override
    public void editAccount(Accounts accounts) {
        try {
            accountsDao.edit(accounts);
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
        }
    }

    @Override
    public void removeAccounts(int id) {
        try {
            accountsDao.deleteAccount(id);
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
        }
    }

    @Override
    public void addAccounts(Accounts accounts) {
        try {
            accountsDao.add(accounts);
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
        }
    }
}
