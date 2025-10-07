package com.azizyilmaz.fee.controller;

import com.azizyilmaz.fee.entity.FeeTransactionMap;
import com.azizyilmaz.fee.service.FeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/fees")
public class FeeController {

    private final FeeService feeService;

    @PostMapping("/calculate")
    public ResponseEntity<FeeTransactionMap> calculate(@RequestBody FeeTransactionMap feeTransactionMap) {
        return ResponseEntity.ok(feeService.calculateFee(feeTransactionMap));
    }
}
