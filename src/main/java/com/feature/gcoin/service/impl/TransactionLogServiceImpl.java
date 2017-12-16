package com.feature.gcoin.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feature.gcoin.dto.request.UserRequest;
import com.feature.gcoin.model.TransactionLog;
import com.feature.gcoin.repository.TransactionLogRepository;
import com.feature.gcoin.service.TransactionLogService;

@Service
public class TransactionLogServiceImpl implements TransactionLogService {

	@Autowired
	private TransactionLogRepository transactionLogRepository;
	
	@Override
	public TransactionLog insert(Long userSendId, UserRequest req, String type) {
		TransactionLog transaction = new TransactionLog(); 
		transaction.setType(type);
		transaction.setUserSendId(userSendId);
		transaction.setUserReceiveId(req.getUserReceiveId());
		transaction.setCoin(req.getTotalCoin());
		transaction.setServiceId(0L);
		transaction.setTransactionLog(type);
		transaction.setCreatAt(new Date());
		transaction.setUpdateAt(new Date());
		
		return transactionLogRepository.save(transaction);
	}


}
