package com.invoicegeneratorapi.entity;

import lombok.Data;

@Data
public class Account {
    private String name;
    private String number;
    private String ifscCode;
}
