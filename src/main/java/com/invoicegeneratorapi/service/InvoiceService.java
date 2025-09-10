package com.invoicegeneratorapi.service;

import com.invoicegeneratorapi.entity.Invoice;
import com.invoicegeneratorapi.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class InvoiceService {

    @Autowired
    private final InvoiceRepository invoiceRepo;

    public InvoiceService(InvoiceRepository invoiceRepo) {
        this.invoiceRepo = invoiceRepo;
    }


    // save invoice data
    public Invoice saveInvoice(Invoice invoice){
         return invoiceRepo.save(invoice);

    }

    //fetch all invoice
    public List<Invoice> featchInvoices(){
        return invoiceRepo.findAll();
    }

    //delete the invoice
    public void deleteInvoice(String id){
        Invoice findInvoice = invoiceRepo.findById(id).orElseThrow(()-> new RuntimeException("invoice not found"+id));
        invoiceRepo.delete(findInvoice);
    }

}
