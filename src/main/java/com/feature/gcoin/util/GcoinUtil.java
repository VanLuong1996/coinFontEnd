package com.feature.gcoin.util;

import com.feature.gcoin.smartcontract.Gcoin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class GcoinUtil {
    private static final Logger log = LoggerFactory.getLogger(GcoinUtil.class);

    public static Web3j web3j;
    public static Credentials credentials;
    public static Gcoin gcoin;

    public static void  loadWeb3j() throws IOException, CipherException {
        web3j = Web3j.build(new HttpService());
        log.info("Connected to Ethereum client version: "
                + web3j.web3ClientVersion().send().getWeb3ClientVersion());
        credentials =Credentials.create("19a0611b5037de40dcdb17ef04a5c56a9d4398c56a34d18bac17900cbb09bfd1");

    }

    public static String deloyGcoin() throws Exception {
        gcoin=Gcoin.deploy(
                web3j, credentials,
                Contract.GAS_PRICE, Contract.GAS_LIMIT).send();

        return gcoin.getContractAddress();
    }
    public void load(String smartAddress){
        gcoin=Gcoin.load(smartAddress, web3j,credentials,
                Contract.GAS_PRICE, Contract.GAS_LIMIT) ;
    }
}
