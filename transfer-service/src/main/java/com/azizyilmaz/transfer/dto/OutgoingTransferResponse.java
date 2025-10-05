package com.azizyilmaz.transfer.dto;

import com.azizyilmaz.transfer.enums.TransferName;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.OffsetTime;

@Getter
@Setter
public class OutgoingTransferResponse {

    private String returnCode;
    private String returnMsg;
    private String message;
    private Long id;
    private TransferName transferName;
    private OffsetDateTime createdDate;
    private OffsetTime createdTime;
    private BigDecimal costAmount;
    private BigDecimal commissionAmount;
    private BigDecimal bsmvAmount;
}
