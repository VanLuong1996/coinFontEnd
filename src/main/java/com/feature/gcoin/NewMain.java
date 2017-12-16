package com.feature.gcoin;

import java.math.BigInteger;

public class NewMain {
    public static void main(String[] args) {
        BigInteger big1 = BigInteger.valueOf(10L);
        BigInteger big2 = BigInteger.valueOf(100000000);

        System.out.println(big1.compareTo(big2));
        System.out.println(big1);
    }
}
