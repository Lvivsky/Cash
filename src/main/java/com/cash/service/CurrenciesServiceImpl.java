package com.cash.service;

import com.cash.dao.CurrenciesDao;
import com.cash.dao.CurrenciesDaoImpl;
import com.cash.model.Currencies;
import lombok.extern.log4j.Log4j;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class CurrenciesServiceImpl implements CurrenciesService {

    private final CurrenciesDao currenciesDao;

    public CurrenciesServiceImpl() {
        this.currenciesDao = new CurrenciesDaoImpl();
    }


    @Override
    public List<Currencies> getAll() {
        List<Currencies> currencies = new ArrayList<>();
        try {
            currencies.addAll(currenciesDao.getAll());
            log.info("Get all currencies");
            return currencies;
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
            return currencies;
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
            return currencies;
        }
    }

    @Override
    public Currencies getByCode(String code) {
        try {
            return currenciesDao.getByCode(code);
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
            return new Currencies();
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
            return new Currencies();
        }
    }

    @Override
    public Currencies getById(int id) {
        try {
            return currenciesDao.getById(id);
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
            return new Currencies();
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
            return new Currencies();
        }
    }

    @Override
    public void add(Currencies currencies) {
        try {
            if (!currenciesDao.existByCode(currencies.getCode()))
                currenciesDao.add(currencies);
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
        }

    }
}
