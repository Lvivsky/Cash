package com.cash.service;

import com.cash.model.Accounts;
import java.util.List;

public interface AccountsService {

    List<Accounts> getAllAccounts();
    Accounts getAccounts(int id);
    boolean isLocked(int id);

    void setLocked(int id, int locked);

    void editAccount(Accounts accounts);
}
