package com.azizyilmaz.fee.controller;

import com.azizyilmaz.fee.entity.Customer;
import com.azizyilmaz.fee.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{mbbNumber}")
    public ResponseEntity<Customer> getByMbbNumber(@PathVariable String mbbNumber) {
        return ResponseEntity.ok(customerService.getCustomerByMbbNumber(mbbNumber));
    }
}
