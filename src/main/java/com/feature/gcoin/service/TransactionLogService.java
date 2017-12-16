package com.feature.gcoin.service;

import com.feature.gcoin.dto.TransactionLogDTO;
import com.feature.gcoin.dto.request.UserRequest;
import com.feature.gcoin.model.TransactionLog;

import java.util.List;

public interface TransactionLogService {

	public TransactionLog insert(Long id, UserRequest req, String type);

	List<TransactionLogDTO> search(Long userId);
}
