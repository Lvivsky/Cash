package com.cash.model;

import com.cash.util.RandomIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrencyRates {

    private Integer id;
    private String guid;
    private String changed;
    private String deleted;
    private String rateDate;
    private String currency1;
    private String currency2;
    private String value1;
    private String value2;

    public CurrencyRates(String changed, String deleted, String rateDate, String currency1, String currency2, String value1, String value2) {
        this.id = RandomIdGenerator.getRandomID();
        this.guid = UUID.randomUUID().toString();
        this.changed = changed;
        this.deleted = deleted;
        this.rateDate = rateDate;
        this.currency1 = currency1;
        this.currency2 = currency2;
        this.value1 = value1;
        this.value2 = value2;
    }
}
