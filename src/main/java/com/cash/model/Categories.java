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
public class Categories {

    private Integer id;
    private String guid;
    private String changed;
    private String deleted;

    private String name;
    private String comment;
    private String parent;

    public Categories(String name, String comment, String parent) {
        this.id = RandomIdGenerator.getRandomID();
        this.guid = UUID.randomUUID().toString();
        this.changed = "";
        this.deleted = "0";
        this.name = name;
        this.comment = comment;
        this.parent = parent;
    }
}