package com.azizyilmaz.transfer.repository;

import com.azizyilmaz.transfer.entity.OutgoingTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutgoingTransferRepository extends JpaRepository<OutgoingTransfer, Long> {
}
