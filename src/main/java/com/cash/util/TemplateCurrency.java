package com.cash.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TemplateCurrency {

    private String date;
    private String charCode;
    private String value;
    private String id;
    private int nominal;
    private int numCode;
    private String name;
    private boolean check;

}
