package com.feature.gcoin.service;

import com.feature.gcoin.dto.UserDTO;
import com.feature.gcoin.dto.VoteDTO;
import com.feature.gcoin.model.User;
import org.web3j.crypto.CipherException;

import java.io.IOException;
import java.util.List;

public interface VoteService {

    //list best of staff and number vote
    UserDTO bestStaffs(String address);
    // choose best staff
    void addBestListStaff() throws Exception;

    int getNumberOfVote(String address) throws Exception;

    boolean voteToStaff(String address,  Long candidateid) throws Exception;

    boolean openSessionVote() throws Exception;
}
