package com.azizyilmaz.fee.service;

import com.azizyilmaz.fee.entity.FeeTransactionMap;
import com.azizyilmaz.fee.repository.FeeTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class FeeService {

    private final FeeTransactionRepository feeTransactionRepository;

    public FeeTransactionMap calculateFee(FeeTransactionMap feeTransactionMap) {
        BigDecimal commission = feeTransactionMap.getAmount().multiply(new BigDecimal("0.01"));
        BigDecimal bsmv = commission.multiply(new BigDecimal("0.05"));
        feeTransactionMap.setCollectedCost(BigDecimal.ZERO);
        feeTransactionMap.setCollectedCommission(commission);
        feeTransactionMap.setCollectedBsmv(bsmv);
        feeTransactionMap.setCollectedFee(commission.add(bsmv));
        return feeTransactionRepository.save(feeTransactionMap);
    }
}
