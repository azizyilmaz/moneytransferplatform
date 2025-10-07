package com.azizyilmaz.fee.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "fee_transaction_map")
public class FeeTransactionMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String mbbNumber;

    @Column(nullable = false)
    private OffsetDateTime date;

    @Column(nullable = false)
    private String channelCode;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private String feePlanCode;

    @Column(nullable = false)
    private BigDecimal collectedCost;

    @Column(nullable = false)
    private BigDecimal collectedCommission;

    @Column(nullable = false)
    private BigDecimal collectedBsmv;

    @Column(nullable = false)
    private BigDecimal collectedFee;

    private BigDecimal refundAmount;

    private OffsetDateTime refundDate;

}