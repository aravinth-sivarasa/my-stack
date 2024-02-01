package io.demo.restservice.microservice1;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.demo.restservice.microservice1.InvoiceDTO.Invoice;

@RestController
@RequestMapping("invoices/v1")
public class InvoiceControllerV1 {
    

    @GetMapping
    List<Invoice> all(){
        return Arrays.asList(//
            new Invoice(UUID.randomUUID().toString()),
            new Invoice(UUID.randomUUID().toString()));
    }
}
