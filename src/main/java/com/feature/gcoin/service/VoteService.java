package com.feature.gcoin.service;

import com.feature.gcoin.dto.UserDTO;

import java.util.List;

public interface VoteService {

    //list best of staff and number vote
    List<UserDTO> bestStaffs(String address);

    // user vote user
    boolean bestStaffsVotes(String addressVoter, String addressCandidate);

    // choose best staff
    boolean addBestStaff(String address);
}
