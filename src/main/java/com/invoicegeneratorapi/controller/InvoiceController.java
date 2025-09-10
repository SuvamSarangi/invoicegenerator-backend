package com.invoicegeneratorapi.controller;


import com.invoicegeneratorapi.entity.Invoice;
import com.invoicegeneratorapi.service.EmailService;
import com.invoicegeneratorapi.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/invoice")
@CrossOrigin("*")
public class InvoiceController {

    @Autowired
   private InvoiceService invoiceService;
    @Autowired
   private EmailService emailService;

    // save the invoice data
    @PostMapping("/save")
    public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice){

        return ResponseEntity.ok(invoiceService.saveInvoice(invoice));
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> featchInvoices(){
       return ResponseEntity.ok(invoiceService.featchInvoices());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable("id") String invoiceId){
      invoiceService.deleteInvoice(invoiceId);
      return ResponseEntity.noContent().build();
    }

    @PostMapping("/sendinvoice")
    public ResponseEntity<?> sendInvoiceEmail(@RequestPart("file") MultipartFile file,
                                              @RequestPart("email") String customerEmail ){

        try {
            emailService.sendInvoiceEmail(customerEmail,file);
            return ResponseEntity.ok("Invoice send successfully..");
        }catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send invoice.."+e.getMessage());
        }

    }
}
