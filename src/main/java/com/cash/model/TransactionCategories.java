package com.cash.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionCategories {

    private int id;
    private String guid;
    private String changed;
    private String deleted;
    private String category;
    private String transaction;

    public TransactionCategories(String category, String transaction) {
        this.guid = String.valueOf(UUID.randomUUID());
        this.changed = String.valueOf(Instant.now().getEpochSecond());
        this.deleted = "0";
        this.category = category;
        this.transaction = transaction;
    }
}
