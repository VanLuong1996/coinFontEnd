package com.feature.gcoin.dto;

public class RequestObject {
    private String username;
    private String password;

    public RequestObject() {
        super();
    }

    public RequestObject(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
