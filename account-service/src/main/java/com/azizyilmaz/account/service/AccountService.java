package com.azizyilmaz.account.service;

import com.azizyilmaz.account.entity.Account;
import com.azizyilmaz.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account getAccount(Long bank, Long branch, Long account) {
        return accountRepository.findByBankCodeAndBranchCodeAndAccountNumber(bank, branch, account)
                .orElseThrow(() -> new RuntimeException("Account not found: " + branch + "-" + account));
    }

    public Account getAccount(String iban) {
        return accountRepository.findByIban(iban).orElseThrow(() -> new RuntimeException("Account not found: " + iban));
    }
}
