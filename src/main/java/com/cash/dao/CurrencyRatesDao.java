package com.cash.dao;

import com.cash.model.CurrencyRates;

public interface CurrencyRatesDao {

    void add(CurrencyRates currencyRates);
    void edit(int id, CurrencyRates currencyRates);
    void remove(int id);
}
