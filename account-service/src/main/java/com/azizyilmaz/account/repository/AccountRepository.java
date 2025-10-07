package com.azizyilmaz.account.repository;

import com.azizyilmaz.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByBankCodeAndBranchCodeAndAccountNumber(Long bank, Long branch, Long account);

    Optional<Account> findByIban(String iban);
}
