package com.feature.gcoin.service.impl;

import java.util.Date;
import java.util.List;

import com.feature.gcoin.common.util.ModelMapperUtil;
import com.feature.gcoin.dto.TransactionLogDTO;
import org.mapstruct.MapperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feature.gcoin.dto.request.UserRequest;
import com.feature.gcoin.model.TransactionLog;
import com.feature.gcoin.repository.TransactionLogRepository;
import com.feature.gcoin.service.TransactionLogService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class TransactionLogServiceImpl implements TransactionLogService {

	@Autowired
	private TransactionLogRepository transactionLogRepository;

	@PersistenceContext
	private EntityManager entityManager;
	
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

	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionLogDTO> search(Long userId) {
		return ModelMapperUtil.maps((List) transactionLogRepository.findByUserSendIdOrUserReceiveId(userId, userId), TransactionLogDTO.class);
	}


}
