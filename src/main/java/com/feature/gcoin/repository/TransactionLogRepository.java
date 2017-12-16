package com.feature.gcoin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feature.gcoin.model.TransactionLog;

public interface TransactionLogRepository extends JpaRepository<TransactionLog, Long> {
    TransactionLog findByUserSendIdOrUserReceiveId(Long userSendId, Long userReceiveId);
}

