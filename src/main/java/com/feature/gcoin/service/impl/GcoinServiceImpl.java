package com.feature.gcoin.service.impl;

import com.feature.gcoin.dto.UserDTO;
import com.feature.gcoin.service.GcoinService;

import java.util.ArrayList;
import java.util.List;

public class GcoinServiceImpl implements GcoinService {

    //add coin to user
    @Override
    public void addCoin(String address, String coin) {
    }

    //tranfer coin from user sent to user receive
    @Override
    public boolean transferCoin(String addressSent, String addressReceive, String coin) {
        return false;
    }

    //get coins of user by address
    @Override
    public Double getCoin(String address) {
        return null;
    }

    //minus coins of user by address
    @Override
    public boolean subtractCoin(String address, String coin) {

        return false;
    }

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
