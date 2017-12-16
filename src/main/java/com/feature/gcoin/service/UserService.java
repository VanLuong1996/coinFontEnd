package com.feature.gcoin.service;

import java.util.List;

import com.feature.gcoin.dto.request.LoginRequest;
import com.feature.gcoin.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {

	User findById(Long id);

	User findByUsername(String userName) throws UsernameNotFoundException;

	List<User> findAll();

	boolean login(LoginRequest loginRequest);
}
