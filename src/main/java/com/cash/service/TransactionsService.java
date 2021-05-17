package com.cash.service;

import com.cash.model.Transactions;

import java.util.List;

public interface TransactionsService {

    List<Transactions> getAll();

    void addIncomeTransaction(String accountId, String operationState, String date, String categoryId, String balance, String comment);
    void addOutcomeTransaction(String accountId, String operationState, String date, String categoryId, String balance, String comment);

}
