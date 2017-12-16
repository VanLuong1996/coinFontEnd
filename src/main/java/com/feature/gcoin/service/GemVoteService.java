package com.feature.gcoin.service;

import java.math.BigInteger;

/**
 * Created by vanluong on 16/12/2017.
 */
public interface GemVoteService {
    BigInteger getVoteCountByAddress(String address) throws Exception;

    boolean getStatusVoter(String address) throws Exception;

    String voteUser(String addressVoter, String addressUser) throws Exception;

    String getUserWin() throws Exception;

}
