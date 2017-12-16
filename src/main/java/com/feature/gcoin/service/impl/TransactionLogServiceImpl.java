package com.feature.gcoin.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.feature.gcoin.common.constant.Constants;
import com.feature.gcoin.common.util.ModelMapperUtil;
import com.feature.gcoin.dto.TransactionLogDTO;
import com.feature.gcoin.model.User;
import com.feature.gcoin.service.UserService;
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

	@Autowired
	private UserService userService;

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertTransfer(Long userSendId, UserRequest req) {
		User userReceive = userService.findByAddress(req.getAddressReceive());
		TransactionLog transaction = new TransactionLog(); 
		transaction.setType(Constants.TransactionType.SUBTRACTION_COIN.name());
		transaction.setUserSendId(userSendId);
		transaction.setUserReceiveId(userReceive.getId());
		transaction.setCoin(req.getTotalCoin());
		transaction.setServiceId(null);
		transaction.setTransactionLog(null);
		transaction.setCreatAt(new Date());
		transaction.setUpdateAt(new Date());
		transactionLogRepository.save(transaction);

		TransactionLog transaction2 = new TransactionLog();
		transaction2.setType(Constants.TransactionType.ADD_COIN.name());
		transaction2.setUserSendId(userReceive.getId());
		transaction2.setUserReceiveId(userSendId);
		transaction2.setCoin(req.getTotalCoin());
		transaction2.setServiceId(null);
		transaction2.setTransactionLog(null);
		transaction2.setCreatAt(new Date());
		transaction2.setUpdateAt(new Date());
		transactionLogRepository.save(transaction2);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionLogDTO> search(Long userId) {
		return ModelMapperUtil.maps((List) transactionLogRepository.search(userId, userId), TransactionLogDTO.class);
	}
}
