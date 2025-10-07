package com.azizyilmaz.account.controller;

import com.azizyilmaz.account.entity.Account;
import com.azizyilmaz.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{bank}/{branch}/{accountNumber}")
    public ResponseEntity<Account> get(@PathVariable Long bank, @PathVariable Long branch, @PathVariable Long accountNumber) {
        return ResponseEntity.ok(accountService.getAccount(bank, branch, accountNumber));
    }

    @GetMapping("/{iban}")
    public ResponseEntity<Account> get(@PathVariable String iban) {
        return ResponseEntity.ok(accountService.getAccount(iban));
    }
}
