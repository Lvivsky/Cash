package com.cash.service;

import com.cash.dao.CurrencyRatesDao;
import com.cash.dao.CurrencyRatesDaoImpl;
import com.cash.model.CurrencyRates;
import lombok.extern.log4j.Log4j;

import java.sql.SQLException;

@Log4j
public class CurrencyRatesServiceImpl implements CurrencyRatesService {

    private CurrencyRatesDao currencyRatesDao;

    public CurrencyRatesServiceImpl() {
        currencyRatesDao = new CurrencyRatesDaoImpl();
    }

    @Override
    public void add(CurrencyRates currencyRates) {
        try {
            currencyRatesDao.add(currencyRates);
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
        }
    }
}
