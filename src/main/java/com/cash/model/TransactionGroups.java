package com.cash.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@ToString
public class TransactionGroups {

    private int id;
    private String guid;
    private String changed;
    private String deleted;
    private String holderDateTime;
    private String position;
    private String recurrence;

    public TransactionGroups() {
        this.guid = UUID.randomUUID().toString();
        this.changed = String.valueOf(Instant.now().getEpochSecond());
        this.deleted = "0";
        this.holderDateTime = "1620518400";
        this.position = "0";
        this.recurrence = "{}";
    }


}
