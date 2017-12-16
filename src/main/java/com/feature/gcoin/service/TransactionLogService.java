package com.feature.gcoin.service;

import org.springframework.stereotype.Service;

import com.feature.gcoin.dto.request.UserRequest;
import com.feature.gcoin.model.TransactionLog;

public interface TransactionLogService {
	public TransactionLog insert(UserRequest req, String type);
}
