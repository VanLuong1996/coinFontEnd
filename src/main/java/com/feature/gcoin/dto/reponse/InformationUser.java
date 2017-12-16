package com.feature.gcoin.dto.reponse;

import java.math.BigInteger;

public class InformationUser {
    String userName; //ten dang nhap
    String email;//mail
    String name; //name
    BigInteger numberCoin; // address

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getNumberCoin() {
        return numberCoin;
    }

    public void setNumberCoin(BigInteger numberCoin) {
        this.numberCoin = numberCoin;
    }
}
