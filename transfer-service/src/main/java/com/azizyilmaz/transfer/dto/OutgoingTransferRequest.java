package com.azizyilmaz.transfer.dto;

import com.azizyilmaz.customer.entity.Customer;
import com.azizyilmaz.transfer.enums.Channel;
import com.azizyilmaz.transfer.enums.Currency;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OutgoingTransferRequest {

    @NotNull
    private Customer remitterCustomer;

    @NotNull
    private Long remitterBankCode;

    @NotNull
    private Long remitterBranchCode;

    private Long remitterAccountNumber;

    private String remitterIban;

    @NotNull
    private Currency currency;

    private Customer recipientCustomer;

    @NotNull
    private Long recipientBankCode;

    private Long recipientBranchCode;

    private Long recipientAccountNumber;

    private String recipientIban;

    @NotNull
    private String recipientNameSurname;

    @NotNull
    @Positive
    private BigDecimal amount;

    private String description;

    @NotNull
    private Channel channel;
}
