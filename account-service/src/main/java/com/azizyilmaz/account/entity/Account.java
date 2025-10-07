package com.azizyilmaz.account.entity;

import com.azizyilmaz.account.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Account {
    @Id
    private Long id;

    @Column(nullable = false)
    private Long bankCode;

    @Column(nullable = false)
    private Long branchCode;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private Long accountNumber;

    @Column(nullable = false, unique = true)
    private String iban;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String mbbNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @Column(nullable = false)
    private OffsetDateTime openedDate;

    private OffsetDateTime closedDate;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    private BigDecimal usableBalance;

    @Column(nullable = false)
    private BigDecimal overdraftBalance;

}
