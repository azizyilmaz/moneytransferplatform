package com.azizyilmaz.fee.repository;

import com.azizyilmaz.fee.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByMbbNumber(String mbbNumber);
}
