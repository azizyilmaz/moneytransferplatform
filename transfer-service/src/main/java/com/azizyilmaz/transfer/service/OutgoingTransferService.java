package com.azizyilmaz.transfer.service;

import com.azizyilmaz.transfer.constant.BankingConstants;
import com.azizyilmaz.transfer.dto.OutgoingTransferRequest;
import com.azizyilmaz.transfer.dto.OutgoingTransferResponse;
import com.azizyilmaz.transfer.entity.OutgoingTransfer;
import com.azizyilmaz.transfer.enums.TransferName;
import com.azizyilmaz.transfer.repository.OutgoingTransferRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.time.OffsetTime;

@Service
@RequiredArgsConstructor
public class OutgoingTransferService {

    private OutgoingTransferRepository outgoingTransferRepository;

    private static OutgoingTransferResponse getOutgoingTransferResponse(OutgoingTransfer outgoingTransfer) {
        OutgoingTransferResponse outgoingTransferResponse = new OutgoingTransferResponse();
        outgoingTransferResponse.setReturnCode("0");
        outgoingTransferResponse.setReturnMsg("success");
        outgoingTransferResponse.setMessage("success");
        outgoingTransferResponse.setId(outgoingTransfer.getId());
        outgoingTransferResponse.setTransferName(outgoingTransfer.getTransferName());
        outgoingTransferResponse.setCreatedDate(outgoingTransfer.getCreatedDate());
        outgoingTransferResponse.setCreatedTime(outgoingTransfer.getCreatedTime());
        // TODO find customer cost amount
        outgoingTransferResponse.setCostAmount(outgoingTransfer.getCostAmount());
        outgoingTransferResponse.setCommissionAmount(outgoingTransfer.getCommissionAmount());
        outgoingTransferResponse.setBsmvAmount(outgoingTransfer.getBsmvAmount());
        return outgoingTransferResponse;
    }

    private static OutgoingTransfer getOutgoingTransfer(OutgoingTransferRequest outgoingTransferRequest) {
        OutgoingTransfer outgoingTransfer = new OutgoingTransfer();
        outgoingTransfer.setCreatedDate(OffsetDateTime.now());
        outgoingTransfer.setCreatedTime(OffsetTime.now());
        outgoingTransfer.setRemitterCustomer(outgoingTransferRequest.getRemitterCustomer());
        outgoingTransfer.setRemitterBankCode(outgoingTransferRequest.getRemitterBankCode());
        outgoingTransfer.setRemitterBranchCode(outgoingTransferRequest.getRemitterBranchCode());
        outgoingTransfer.setRemitterAccountNumber(outgoingTransferRequest.getRemitterAccountNumber());
        outgoingTransfer.setRemitterIban(outgoingTransferRequest.getRemitterIban());
        outgoingTransfer.setCurrency(outgoingTransferRequest.getCurrency());
        outgoingTransfer.setRecipientCustomer(outgoingTransferRequest.getRecipientCustomer());
        outgoingTransfer.setRecipientBankCode(outgoingTransferRequest.getRecipientBankCode());
        outgoingTransfer.setRecipientBranchCode(outgoingTransferRequest.getRecipientBranchCode());
        outgoingTransfer.setRecipientAccountNumber(outgoingTransferRequest.getRecipientAccountNumber());
        outgoingTransfer.setRecipientIban(outgoingTransferRequest.getRecipientIban());
        outgoingTransfer.setRecipientNameSurname(outgoingTransferRequest.getRecipientNameSurname());
        outgoingTransfer.setAmount(outgoingTransferRequest.getAmount());
        outgoingTransfer.setDescription(outgoingTransferRequest.getDescription());
        outgoingTransfer.setChannel(outgoingTransferRequest.getChannel());
        outgoingTransfer.setTransferName(transferDetermination(outgoingTransferRequest.getRecipientBankCode(), outgoingTransferRequest.getRecipientCustomer().getId(), outgoingTransferRequest.getRemitterCustomer().getId()));
        return outgoingTransfer;
    }

    private static TransferName transferDetermination(@NotNull Long recipientBankCode, Long recipientCustomerId, Long remitterCustomerId) {
        TransferName transferName;
        if (BankingConstants.BANK_CODE.equals(recipientBankCode)) {
            if (recipientCustomerId.equals(remitterCustomerId)) {
                transferName = TransferName.VIRMAN;
            } else {
                transferName = TransferName.HAVALE;
            }
        } else {
            // TODO it will be controlled, EFT or FAST ?
            transferName = TransferName.EFT;
        }
        return transferName;
    }

    @Transactional
    public OutgoingTransferResponse transfer(OutgoingTransferRequest outgoingTransferRequest) {
        controlRequest(outgoingTransferRequest);
        OutgoingTransfer outgoingTransfer = getOutgoingTransfer(outgoingTransferRequest);
        outgoingTransferRepository.save(outgoingTransfer);
        return getOutgoingTransferResponse(outgoingTransfer);
    }

    private void controlRequest(OutgoingTransferRequest outgoingTransferRequest) {

    }

}
