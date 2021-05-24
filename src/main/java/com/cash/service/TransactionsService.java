package com.cash.service;

import com.cash.model.Transactions;

import java.util.List;

public interface TransactionsService {

    List<Transactions> getAll();

    void addIncomeTransaction(String accountId, String operationState, String date, String categoryId, String balance, String comment);
    void addOutcomeTransaction(String accountId, String operationState, String date, String categoryId, String balance, String comment);


    List<Transactions> getTransactionsIncomeAccount(int id);
    List<Transactions> getTransactionsExpanseAccount(int id);


    List<Transactions> getByIncomeAccount(String accId);
    List<Transactions> getByExpanseAccount(String accId);


    List<Transactions> getByIncomeAccountAndStateRecursive(String accId, String stateId);
    List<Transactions> getByExpenseAccountAndStateRecursive(String accId, String stateId);

}
