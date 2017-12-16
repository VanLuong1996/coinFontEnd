package com.feature.gcoin.service;

import com.feature.gcoin.dto.TransactionLogDTO;
import com.feature.gcoin.dto.request.UserRequest;
import com.feature.gcoin.model.TransactionLog;

import java.util.List;

public interface TransactionLogService {
	public void insertTransfer(Long id, UserRequest req);

	List<TransactionLogDTO> search(Long userId);
}
