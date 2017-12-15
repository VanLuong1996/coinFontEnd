//package com.feature.gcoin.smartcontract;
//
//import java.math.BigInteger;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.concurrent.Callable;
//import org.web3j.abi.TypeReference;
//import org.web3j.abi.datatypes.Address;
//import org.web3j.abi.datatypes.Bool;
//import org.web3j.abi.datatypes.DynamicArray;
//import org.web3j.abi.datatypes.Function;
//import org.web3j.abi.datatypes.Type;
//import org.web3j.abi.datatypes.generated.Uint256;
//import org.web3j.crypto.Credentials;
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.core.RemoteCall;
//import org.web3j.protocol.core.methods.response.TransactionReceipt;
//import org.web3j.tuples.generated.Tuple2;
//import org.web3j.tx.Contract;
//import org.web3j.tx.TransactionManager;
//
///**
// * <p>Auto generated code.
// * <p><strong>Do not modify!</strong>
// * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
// * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
// * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
// *
// * <p>Generated with web3j version 3.1.1.
// */
//public final class GemVote extends Contract {
//    private static final String BINARY = "6060604052341561000f57600080fd5b6107318061001e6000396000f3006060604052600436106100825763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663013cf08b81146100875780631873320f146100bf57806383920871146100f8578063a3ec138d14610117578063c177456314610159578063cb72c11714610188578063cd5adbef146101ee575b600080fd5b341561009257600080fd5b61009d600435610201565b604051600160a060020a03909216825260208201526040908101905180910390f35b34156100ca57600080fd5b6100e4600160a060020a0360043581169060243516610237565b604051901515815260200160405180910390f35b341561010357600080fd5b6100e4600160a060020a03600435166102f3565b341561012257600080fd5b610136600160a060020a03600435166103cc565b6040519115158252600160a060020a031660208201526040908101905180910390f35b341561016457600080fd5b61016c6103f1565b604051600160a060020a03909116815260200160405180910390f35b341561019357600080fd5b61019b6104a7565b60405160208082528190810183818151815260200191508051906020019060200280838360005b838110156101da5780820151838201526020016101c2565b505050509050019250505060405180910390f35b34156101f957600080fd5b61019b610585565b600180548290811061020f57fe5b600091825260209091206002909102018054600190910154600160a060020a03909116915082565b600160a060020a03821660009081526020819052604081208054829060ff161561026457600092506102eb565b5060005b6001548110156102e65783600160a060020a031660018281548110151561028b57fe5b6000918252602090912060029091020154600160a060020a031614156102de57600180828154811015156102bb57fe5b6000918252602090912060016002909202010180549091019055815460ff191682555b600101610268565b600192505b505092915050565b6000805b60015481101561034b5782600160a060020a031660018281548110151561031a57fe5b6000918252602090912060029091020154600160a060020a0316141561034357600091506103c6565b6001016102f7565b6001805480820161035c8382610645565b9160005260206000209060020201600060408051908101604052600160a060020a0387168152600060208201529190508151815473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03919091161781556020820151600191820155935050505b50919050565b60006020819052908152604090205460ff8116906101009004600160a060020a031682565b6000806000806001600081548110151561040757fe5b90600052602060002090600202019250600091505b60015460001901821015610496575060015b60015481101561048b57826001015460018281548110151561044c57fe5b906000526020600020906002020160010154111561048357600180548290811061047257fe5b906000526020600020906002020192505b60010161042e565b60019091019061041c565b505054600160a060020a0316919050565b6104af610676565b6000805b6001548110156105245781548290600181016104cf8382610688565b916000526020600020900160006001848154811015156104eb57fe5b600091825260209091206002909102015482546101009290920a600160a060020a039182168102910219909116179055506001016104b3565b8180548060200260200160405190810160405280929190818152602001828054801561057957602002820191906000526020600020905b8154600160a060020a0316815260019091019060200180831161055b575b50505050509250505090565b61058d610676565b6000805b6001548110156105ef5781548290600181016105ad8382610688565b916000526020600020900160006001848154811015156105c957fe5b906000526020600020906002020160010154909190915055508080600101915050610591565b8180548060200260200160405190810160405280929190818152602001828054801561057957602002820191906000526020600020905b8154815260200190600101908083116106265750505050509250505090565b8154818355818115116106715760020281600202836000526020600020918201910161067191906106ac565b505050565b60206040519081016040526000815290565b815481835581811511610671576000838152602090206106719181019083016106eb565b6106e891905b808211156106e457805473ffffffffffffffffffffffffffffffffffffffff19168155600060018201556002016106b2565b5090565b90565b6106e891905b808211156106e457600081556001016106f15600a165627a7a72305820244e303c8fa2375dfef31ba326b9d23c988d98a5b35ad825037f5cb092908cbf0029";
//
//    private GemVote(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
//        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
//    }
//
//    private GemVote(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
//        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
//    }
//
//    public RemoteCall<Tuple2<String, BigInteger>> proposals(BigInteger param0) {
//        final Function function = new Function("proposals",
//                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
//                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
//        return new RemoteCall<Tuple2<String, BigInteger>>(
//                new Callable<Tuple2<String, BigInteger>>() {
//                    @Override
//                    public Tuple2<String, BigInteger> call() throws Exception {
//                        List<Type> results = executeCallMultipleValueReturn(function);;
//                        return new Tuple2<String, BigInteger>(
//                                (String) results.get(0).getValue(),
//                                (BigInteger) results.get(1).getValue());
//                    }
//                });
//    }
//
//    public RemoteCall<TransactionReceipt> voteUser(String adVoter, String adProposal) {
//        Function function = new Function(
//                "voteUser",
//                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(adVoter),
//                new org.web3j.abi.datatypes.Address(adProposal)),
//                Collections.<TypeReference<?>>emptyList());
//        return executeRemoteCallTransaction(function);
//    }
//
//    public RemoteCall<TransactionReceipt> addProposal(String adProposal) {
//        Function function = new Function(
//                "addProposal",
//                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(adProposal)),
//                Collections.<TypeReference<?>>emptyList());
//        return executeRemoteCallTransaction(function);
//    }
//
//    public RemoteCall<Tuple2<Boolean, String>> voters(String param0) {
//        final Function function = new Function("voters",
//                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)),
//                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Address>() {}));
//        return new RemoteCall<Tuple2<Boolean, String>>(
//                new Callable<Tuple2<Boolean, String>>() {
//                    @Override
//                    public Tuple2<Boolean, String> call() throws Exception {
//                        List<Type> results = executeCallMultipleValueReturn(function);;
//                        return new Tuple2<Boolean, String>(
//                                (Boolean) results.get(0).getValue(),
//                                (String) results.get(1).getValue());
//                    }
//                });
//    }
//
//    public RemoteCall<String> getUserWin() {
//        Function function = new Function("getUserWin",
//                Arrays.<Type>asList(),
//                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
//        return executeRemoteCallSingleValueReturn(function, String.class);
//    }
//
//    public RemoteCall<List<String>> getListProposalAddress() {
//        Function function = new Function("getListProposalAddress",
//                Arrays.<Type>asList(),
//                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
//        return executeRemoteCallSingleValueReturn(function, List<String>.class);
//    }
//
//    public RemoteCall<List<BigInteger>> getListProposalVoteCount() {
//        Function function = new Function("getListProposalVoteCount",
//                Arrays.<Type>asList(),
//                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
//        return executeRemoteCallSingleValueReturn(function, List<BigInteger>.class);
//    }
//
//    public static RemoteCall<GemVote> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
//        return deployRemoteCall(GemVote.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
//    }
//
//    public static RemoteCall<GemVote> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
//        return deployRemoteCall(GemVote.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
//    }
//
//    public static GemVote load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
//        return new GemVote(contractAddress, web3j, credentials, gasPrice, gasLimit);
//    }
//
//    public static GemVote load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
//        return new GemVote(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
//    }
//}
