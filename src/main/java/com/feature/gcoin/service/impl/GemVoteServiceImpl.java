package com.feature.gcoin.service.impl;

import com.feature.gcoin.service.GemVoteService;
import com.feature.gcoin.util.GemVoteUtil;

import java.math.BigInteger;

/**
 * Created by vanluong on 16/12/2017.
 */
public class GemVoteServiceImpl implements GemVoteService {
    @Override
    public BigInteger getVoteCountByAddress(String address) throws Exception {
        return GemVoteUtil.gemVote.getVoteCountByAddress(address).send();
    }

    @Override
    public boolean getStatusVoter(String address) throws Exception {

        return GemVoteUtil.gemVote.getStatusVoter(address).send();
    }

    @Override
    public String voteUser(String addressVoter, String addressUser) throws Exception {
        return GemVoteUtil.gemVote.voteUser(addressVoter, addressUser).send().getBlockHash();
    }

    @Override
    public String getUserWin() throws Exception {
        return GemVoteUtil.gemVote.getUserWin().send().toString();
    }
}
