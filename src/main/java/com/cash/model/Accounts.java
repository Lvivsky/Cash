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
public class Accounts {

    private Integer id;
    private String guid;
    private String changed;
    private String deleted;
    private String name;
    private String startingBalance;
    private String currency;
    private String comment;
    private String locked;

    public Accounts(
            String changed,
            String deleted,
            String name,
            String startingBalance,
            String currency,
            String comment,
            String locked) {
        this.id = RandomIdGenerator.getRandomID();
        this.guid = UUID.randomUUID().toString();
        this.changed = changed;
        this.deleted = deleted;
        this.name = name;
        this.startingBalance = startingBalance;
        this.currency = currency;
        this.comment = comment;
        this.locked = locked;
    }
}
