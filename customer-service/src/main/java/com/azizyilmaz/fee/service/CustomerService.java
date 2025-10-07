package com.azizyilmaz.fee.service;

import com.azizyilmaz.fee.entity.Customer;
import com.azizyilmaz.fee.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer getCustomerByMbbNumber(String mbbNumber) {
        return customerRepository.findByMbbNumber(mbbNumber).orElseThrow(() -> new RuntimeException("Customer not found: " + mbbNumber));
    }
}
