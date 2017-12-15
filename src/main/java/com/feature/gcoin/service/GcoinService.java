package com.feature.gcoin.service;

import com.feature.gcoin.dto.UserDTO;

import java.util.List;

public interface GcoinService {
    //add coin to user
    void addCoin(String address, String coin);

    //tranfer coin from user sent to user receive
    boolean transferCoin(String addressSent, String addressReceive, String coin);

    //get coins of user by address
    boolean getCoin(String address);

    //minus coins of user by address
    boolean subtractCoin(String address, String coin);

    //list best of staff and number vote
    List<UserDTO> bestStaffs(String address);

    // user vote user
    boolean bestStaffsVotes(String addressVoter, String addressCandidate);

    // choose best staff
    boolean addBestStaff(String address);


}
