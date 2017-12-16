package com.feature.gcoin.service.impl;

import com.feature.gcoin.dto.UserDTO;
import com.feature.gcoin.service.VoteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    //list best of staff and number vote
    @Override
    public List<UserDTO> bestStaffs(String address) {
        List<UserDTO> lstDTO = new ArrayList<>();
        return lstDTO;
    }

    // user vote user
    @Override
    public boolean bestStaffsVotes(String addressVoter, String addressCandidate) {
        return false;
    }

    // choose best staff
    @Override
    public boolean addBestStaff(String address) {
        return false;
    }

}
