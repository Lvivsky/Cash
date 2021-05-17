package com.cash.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@ToString
public class Transactions {

    private int id;
    private String guid;
    private String changed;
    private String deleted;

    private String group;
    private String position;
    private String budgetDate;
    private String executed;
    private String locked;

    private String incomeAccount;
    private String incomeAmount;
    private String incomeBalance;

    private String expenseAccount;
    private String expenseAmount;
    private String expenseBalance;

    private String quantity;
    private String comment;
    private String extraComment1;
    private String extraComment2;
    private String extraComment3;
    private String extraComment4;

    private String budgetPeriodEnd;

    public Transactions() {
        this.guid = UUID.randomUUID().toString();
        this.changed = String.valueOf(Instant.now().getEpochSecond());
        this.deleted = "0";
        this.position = "0";
        this.budgetDate = String.valueOf(Instant.now().getEpochSecond());

        this.executed = "1"; // if finish -> 1, no -> 0
        this.locked = "0";
        this.incomeAccount = null;
        this.incomeAmount = null;
        this.incomeBalance = null;

        this.expenseAccount = null;
        this.expenseAmount = null;
        this.expenseBalance = null;

        this.quantity = "10000";
        this.comment = "";
        this.extraComment1 = "";
        this.extraComment2 = "";
        this.extraComment3 = "";
        this.extraComment4 = "";
        this.budgetPeriodEnd = String.valueOf(Instant.now().getEpochSecond());
    }



}
