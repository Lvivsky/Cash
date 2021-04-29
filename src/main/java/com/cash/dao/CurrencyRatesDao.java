package com.cash.dao;

import com.cash.model.CurrencyRates;

import java.sql.SQLException;

public interface CurrencyRatesDao {

    void add(CurrencyRates currencyRates) throws SQLException, ClassNotFoundException;
    void edit(int id, CurrencyRates currencyRates);
    void remove(int id);
}
