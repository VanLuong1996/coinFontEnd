package com.feature.gcoin.service;

import com.feature.gcoin.dto.request.UserRequest;
import com.feature.gcoin.model.TransactionLog;

public interface TransactionLogService {
	public TransactionLog insert(Long id, UserRequest req, String type);
}
