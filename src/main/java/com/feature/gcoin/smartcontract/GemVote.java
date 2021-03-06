package com.feature.gcoin.smartcontract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.1.1.
 */
public final class GemVote extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b6105b58061001e6000396000f3006060604052600436106100825763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663013cf08b81146100875780631873320f146100bf57806383920871146100f857806384bc686e14610117578063a3ec138d14610136578063c177456314610178578063d1b69531146101a7575b600080fd5b341561009257600080fd5b61009d6004356101d8565b604051600160a060020a03909216825260208201526040908101905180910390f35b34156100ca57600080fd5b6100e4600160a060020a036004358116906024351661020e565b604051901515815260200160405180910390f35b341561010357600080fd5b6100e4600160a060020a03600435166102cd565b341561012257600080fd5b6100e4600160a060020a03600435166103a6565b341561014157600080fd5b610155600160a060020a03600435166103c4565b6040519115158252600160a060020a031660208201526040908101905180910390f35b341561018357600080fd5b61018b6103e9565b604051600160a060020a03909116815260200160405180910390f35b34156101b257600080fd5b6101c6600160a060020a036004351661049f565b60405190815260200160405180910390f35b60018054829081106101e657fe5b600091825260209091206002909102018054600190910154600160a060020a03909116915082565b600160a060020a03821660009081526020819052604081208054829060ff161561023b57600092506102c5565b5060005b6001548110156102c05783600160a060020a031660018281548110151561026257fe5b6000918252602090912060029091020154600160a060020a031614156102b8576001808281548110151561029257fe5b60009182526020909120600160029092020181018054909201909155825460ff19161782555b60010161023f565b600192505b505092915050565b6000805b6001548110156103255782600160a060020a03166001828154811015156102f457fe5b6000918252602090912060029091020154600160a060020a0316141561031d57600091506103a0565b6001016102d1565b600180548082016103368382610519565b9160005260206000209060020201600060408051908101604052600160a060020a0387168152600060208201529190508151815473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03919091161781556020820151600191820155935050505b50919050565b600160a060020a031660009081526020819052604090205460ff1690565b60006020819052908152604090205460ff8116906101009004600160a060020a031682565b600080600080600160008154811015156103ff57fe5b90600052602060002090600202019250600091505b6001546000190182101561048e575060015b60015481101561048357826001015460018281548110151561044457fe5b906000526020600020906002020160010154111561047b57600180548290811061046a57fe5b906000526020600020906002020192505b600101610426565b600190910190610414565b505054600160a060020a0316919050565b600080805b6001548110156105125783600160a060020a03166001828154811015156104c757fe5b6000918252602090912060029091020154600160a060020a0316141561050a5760018054829081106104f557fe5b90600052602060002090600202016001015491505b6001016104a4565b5092915050565b81548183558181151161054557600202816002028360005260206000209182019101610545919061054a565b505050565b61058691905b8082111561058257805473ffffffffffffffffffffffffffffffffffffffff1916815560006001820155600201610550565b5090565b905600a165627a7a723058201c814cf5ba40049a34a0645af697e6f36d03fa15001b0d1b4c29ccbc17883d090029";

    private GemVote(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private GemVote(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<Tuple2<String, BigInteger>> proposals(BigInteger param0) {
        final Function function = new Function("proposals",
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<String, BigInteger>>(
                new Callable<Tuple2<String, BigInteger>>() {
                    @Override
                    public Tuple2<String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple2<String, BigInteger>(
                                (String) results.get(0).getValue(),
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> voteUser(String adVoter, String adProposal) {
        Function function = new Function(
                "voteUser",
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(adVoter),
                        new org.web3j.abi.datatypes.Address(adProposal)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addProposal(String adProposal) {
        Function function = new Function(
                "addProposal",
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(adProposal)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> getStatusVoter(String adVoter) {
        Function function = new Function("getStatusVoter",
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(adVoter)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Tuple2<Boolean, String>> voters(String param0) {
        final Function function = new Function("voters",
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple2<Boolean, String>>(
                new Callable<Tuple2<Boolean, String>>() {
                    @Override
                    public Tuple2<Boolean, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple2<Boolean, String>(
                                (Boolean) results.get(0).getValue(),
                                (String) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<String> getUserWin() {
        Function function = new Function("getUserWin",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> getVoteCountByAddress(String adProposal) {
        Function function = new Function("getVoteCountByAddress",
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(adProposal)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<GemVote> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(GemVote.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<GemVote> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(GemVote.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static GemVote load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new GemVote(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static GemVote load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new GemVote(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
