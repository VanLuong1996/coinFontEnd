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
    public boolean getCoin(String address) {
        return false;
    }

    //minus coins of user by address
    @Override
    public boolean subtractCoin(String address, String coin) {

        return false;
    }


}
