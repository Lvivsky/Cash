package com.cash.service;

import com.cash.model.Accounts;
import java.util.List;

public interface AccountsService {

    List<Accounts> getAllAccounts();
    List<Accounts> getAllAccountsWithCurrencyCode();
    List<Accounts> getAllAccountsWithCurrencyCodeAndNotLocked();
    Accounts getAccounts(int id);
    boolean isLocked(int id);

    void setLocked(int id, int locked);

    void editAccount(Accounts accounts);

    void removeAccounts(int id);

    void addAccounts(Accounts accounts);
}
