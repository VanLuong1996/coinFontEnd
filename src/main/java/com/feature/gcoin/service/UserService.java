package com.feature.gcoin.service;

import java.util.List;

import com.feature.gcoin.model.User;

public interface UserService {
	User findById(Long id);

	User findByUsername(String username);

	List<User> findAll();
}
