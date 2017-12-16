package com.feature.gcoin.service;

import com.feature.gcoin.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GcoinService {
    //add coin to user
    void addCoin(String address, String coin);

    //tranfer coin from user sent to user receive
    boolean transferCoin(String addressSent, String addressReceive, String coin);

    //get coins of user by address
    Double getCoin(String address);

    //minus coins of user by address
    boolean subtractCoin(String address, String coin);




}
