package com.cash.service;

import com.cash.model.Currencies;

import java.util.List;

public interface CurrenciesService {

    List<Currencies> getAll();

    void add(Currencies currencies);

}
