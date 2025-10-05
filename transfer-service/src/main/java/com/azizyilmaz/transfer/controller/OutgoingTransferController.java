package com.azizyilmaz.transfer.controller;

import com.azizyilmaz.transfer.dto.OutgoingTransferRequest;
import com.azizyilmaz.transfer.dto.OutgoingTransferResponse;
import com.azizyilmaz.transfer.service.OutgoingTransferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class OutgoingTransferController {

    private final OutgoingTransferService outgoingTransferService;

    @PostMapping("/transfer")
    public ResponseEntity<OutgoingTransferResponse> transfer(@Valid @RequestBody OutgoingTransferRequest outgoingTransferRequest) {
        return ResponseEntity.ok(outgoingTransferService.transfer(outgoingTransferRequest));
    }

}
