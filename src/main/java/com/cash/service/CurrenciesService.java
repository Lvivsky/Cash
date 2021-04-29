package com.cash.service;

import com.cash.model.Currencies;

import java.util.List;

public interface CurrenciesService {

    List<Currencies> getAll();

    Currencies getByCode(String code);
    Currencies getById(int id);

    void add(Currencies currencies);

}
