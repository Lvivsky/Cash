package com.cash.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
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



}
