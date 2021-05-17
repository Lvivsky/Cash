package com.cash.model;

import com.cash.util.RandomIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Currencies {

    private Integer id;
    private String guid;
    private String changed;
    private String deleted;
    private String code;
    private String name;
    private String precision;

    public Currencies(String deleted, String code, String name, String precision) {
        this.id = RandomIdGenerator.getRandomID();
        this.guid = UUID.randomUUID().toString();
        this.changed = String.valueOf(Instant.now().getEpochSecond());
        this.deleted = deleted;
        this.code = code;
        this.name = name;
        this.precision = precision;
    }
}
