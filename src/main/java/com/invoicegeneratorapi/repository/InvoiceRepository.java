package com.invoicegeneratorapi.repository;

import com.invoicegeneratorapi.entity.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvoiceRepository extends MongoRepository<Invoice,String> {
}
