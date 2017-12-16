package com.feature.gcoin.service.impl;

import java.util.List;

import com.feature.gcoin.dto.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.feature.gcoin.model.User;
import com.feature.gcoin.repository.UserRepository;
import com.feature.gcoin.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) throws AccessDeniedException {
        User u = userRepository.findOne(id);
        return u;
    }

    @Override
    public User findByUsername(String userName) throws UsernameNotFoundException {
        User u = userRepository.findByUsername(userName);
        return u;
    }

    public List<User> findAll() throws AccessDeniedException {
        List<User> result = userRepository.findAll();
        return result;
    }

    @Override
    public boolean login(LoginRequest loginRequest) {
        List<User> lst = userRepository.login(loginRequest.getUsername(), loginRequest.getPassword());
        return lst != null & lst.size()>0 ? true : false;
    }

}
