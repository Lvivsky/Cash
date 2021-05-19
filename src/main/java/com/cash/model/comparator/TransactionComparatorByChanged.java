package com.cash.model.comparator;

import com.cash.model.Transactions;

import java.util.Comparator;

public class TransactionComparatorByChanged implements Comparator<Transactions> {

    @Override
    public int compare(Transactions o1, Transactions o2) {
        return o1.getChanged().compareTo(o2.getChanged());
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
