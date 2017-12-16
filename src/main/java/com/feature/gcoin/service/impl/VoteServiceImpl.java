package com.feature.gcoin.service.impl;

import com.feature.gcoin.common.util.ModelMapperUtil;
import com.feature.gcoin.dto.UserDTO;
import com.feature.gcoin.dto.VoteDTO;
import com.feature.gcoin.model.User;
import com.feature.gcoin.repository.UserRepository;
import com.feature.gcoin.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private UserRepository userRepository;

    //list best of staff and number vote
    @Override
    public UserDTO bestStaffs(String address) {
        UserDTO userDTO = new UserDTO();
        User user = userRepository.findByUsername("tiennv");
        userDTO = ModelMapperUtil.map(user, UserDTO.class);
        return userDTO;
    }

    // user vote user
    @Override
    public boolean bestStaffsVotes(String addressVoter, String addressCandidate) {
        return false;
    }

    // choose best staff
    @Override
    public boolean addBestStaff(String address) {
        return true;
    }

    @Override
    public int getNumberOfVote(String address) {
        return 5;
    }

    @Override
    public boolean voteToStaff(VoteDTO voteDTO) {
        return true;
    }

    @Override
    public boolean openSessionVote() {
        return true;
    }

}
