package com.feature.gcoin.util;

import com.feature.gcoin.smartcontract.GemVote;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;

import java.io.IOException;

/**
 * Created by vanluong on 16/12/2017.
 */
public class GemVoteUtil {
    public static Web3j web3j;

    public static Credentials credentials;
    public static GemVote gemVote;

    public static void loadWeb3j() throws IOException, CipherException {
        web3j = Web3j.build(new HttpService());
        credentials =Credentials.create("57f47d0fbea16b6bb115b598a8f608b1fb30dd81b6e5cf944385128caed6d79c");

    }
//chi deploy 1 lan
    public static String deloyGemVote() throws Exception {
        gemVote=GemVote.deploy(
                web3j, credentials,
                Contract.GAS_PRICE, Contract.GAS_LIMIT).send();
        return gemVote.getContractAddress();
    }
    //sau khi deploy chay lai thi load lai
    public void load(String contractAddress){
        gemVote=GemVote.load(contractAddress,web3j, credentials,Contract.GAS_PRICE, Contract.GAS_LIMIT);
    }
}
