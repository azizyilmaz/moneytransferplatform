package com.azizyilmaz.transfer.entity;

import com.azizyilmaz.fee.entity.Customer;
import com.azizyilmaz.transfer.enums.Channel;
import com.azizyilmaz.transfer.enums.Currency;
import com.azizyilmaz.transfer.enums.TransferName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.OffsetTime;

@Entity
@Table(name = "outgoing_transfers")
@Getter
@Setter
public class OutgoingTransfer {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransferName transferName;

    @Column(nullable = false)
    private OffsetDateTime createdDate;

    @Column(nullable = false)
    private OffsetTime createdTime;

    @ManyToOne
    @JoinColumn(name = "remitter_customer_id")
    private Customer remitterCustomer;

    @Column(nullable = false)
    private Long remitterBankCode;

    @Column(nullable = false)
    private Long remitterBranchCode;

    private Long remitterAccountNumber;

    private String remitterIban;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "recipient_customer_id")
    private Customer recipientCustomer;

    @Column(nullable = false)
    private Long recipientBankCode;

    private Long recipientBranchCode;

    private Long recipientAccountNumber;

    private String recipientIban;

    @Column(nullable = false, length = 100)
    private String recipientNameSurname;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private BigDecimal costAmount;

    @Column(nullable = false)
    private BigDecimal commissionAmount;

    @Column(nullable = false)
    private BigDecimal bsmvAmount;

    @Column(length = 200)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Channel channel;
}
