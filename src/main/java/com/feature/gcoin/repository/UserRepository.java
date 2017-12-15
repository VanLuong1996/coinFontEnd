package com.feature.gcoin.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.feature.gcoin.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername( String username );
}

