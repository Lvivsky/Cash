package com.cash.dao;

import com.cash.core.SqliteConnection;
import com.cash.model.CurrencyRates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CurrencyRatesDaoImpl implements CurrencyRatesDao {

    @Override
    public void add(CurrencyRates currencyRates) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO CurrencyRates (Guid,Changed,Deleted,RateDate,Currency1,Currency2,Value1,Value2) VALUES (?,?,?,?,?,?,?,?)")
                ) {
            statement.setString(1,currencyRates.getGuid());
            statement.setString(2,currencyRates.getChanged());
            statement.setString(3,currencyRates.getDeleted());
            statement.setString(4,currencyRates.getRateDate());
            statement.setString(5,currencyRates.getCurrency1());
            statement.setString(6,currencyRates.getCurrency2());
            statement.setString(7,currencyRates.getValue1());
            statement.setString(8,currencyRates.getValue2());
            statement.execute();
        }
    }

    @Override
    public void edit(int id, CurrencyRates currencyRates) {

    }

    @Override
    public void remove(int id) {

    }
}
