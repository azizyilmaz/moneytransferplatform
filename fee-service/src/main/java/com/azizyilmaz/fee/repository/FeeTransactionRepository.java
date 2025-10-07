package com.azizyilmaz.fee.repository;

import com.azizyilmaz.fee.entity.FeeTransactionMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeTransactionRepository extends JpaRepository<FeeTransactionMap, Integer> {
}
