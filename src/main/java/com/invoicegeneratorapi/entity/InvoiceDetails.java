package com.invoicegeneratorapi.entity;

import lombok.Data;

@Data
public class InvoiceDetails {
    private String number;
    private String date;
    private String dueDate;
}
