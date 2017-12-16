package com.feature.gcoin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feature.gcoin.model.TransactionLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionLogRepository extends JpaRepository<TransactionLog, Long> {
    @Query("select c from TransactionLog c where c.userSendId = (:userSendId) or c.userReceiveId = (:userReceiveId)")
    List<TransactionLog> search(@Param("userSendId") Long userSendId, @Param("userReceiveId") Long userReceiveId);

    TransactionLog findByUserSendIdOrUserReceiveId(Long userSendId, Long userReceiveId);

//    TransactionLog save(TransactionLog transactionLog);
}

