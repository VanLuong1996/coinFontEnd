package com.feature.gcoin.service.impl;

import com.feature.gcoin.common.constant.Constants;
import com.feature.gcoin.common.util.ModelMapperUtil;
import com.feature.gcoin.dto.UserDTO;
import com.feature.gcoin.dto.VoteDTO;
import com.feature.gcoin.model.TransactionLog;
import com.feature.gcoin.model.User;
import com.feature.gcoin.repository.TransactionLogRepository;
import com.feature.gcoin.repository.UserRepository;
import com.feature.gcoin.service.GemVoteService;
import com.feature.gcoin.service.VoteService;
import com.feature.gcoin.smartcontract.GemVote;
import com.feature.gcoin.util.GemVoteUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {
    private final Logger logger = LoggerFactory.getLogger(VoteServiceImpl.class);


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GemVoteService gemVoteService;
    @Autowired
    private TransactionLogRepository transactionLogRepository;

    //list best of staff and number vote
    @Override
    public UserDTO bestStaffs(String address) {
        UserDTO userDTO = new UserDTO();
        User user = userRepository.findByUsername("tiennv");
        userDTO = ModelMapperUtil.map(user, UserDTO.class);
        return userDTO;
    }

    // choose best staff
    @Override
    public void addBestListStaff() throws Exception {
        List<User> lst = userRepository.findByIsFeature();
        for (User user : lst) {
            gemVoteService.addCandidate(user.getAddress());
        }
        logger.info("Them nguoi ung cu");

    }

    @Override
    public int getNumberOfVote(String address) throws Exception {
        return gemVoteService.getVoteCountByAddress(address).intValue();
    }

    @Override
    public boolean voteToStaff(String address, Long candidateId) throws Exception {

        List<User> userVoters = userRepository.findByAddress(address);
        userVoters.get(0);
        User userCandidate = userRepository.findById(candidateId);

        Boolean checkVote = gemVoteService.getStatusVoter(userVoters.get(0).getAddress());
        if (checkVote) {
            return false;
        } else {
            String log = gemVoteService.voteUser(userVoters.get(0).getAddress(), userCandidate.getAddress());
            //log
            TransactionLog transaction = new TransactionLog();
            transaction.setType(Constants.TransactionType.VOTE.name());
            transaction.setUserSendId(userVoters.get(0).getId());
            transaction.setUserReceiveId(userCandidate.getId());
            transaction.setCoin(null);
            transaction.setServiceId(null);
            transaction.setTransactionLog(log);
            transaction.setCreatAt(new Date());
            transaction.setUpdateAt(new Date());
            transactionLogRepository.save(transaction);
        }
        return true;
    }

    @Override
    public boolean openSessionVote() throws Exception {
        GemVoteUtil.loadWeb3j();
        GemVoteUtil.deloyGemVote();
        addBestListStaff();
        return true;
    }

}
