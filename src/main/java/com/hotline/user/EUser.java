package com.hotline.user;

public enum EUser {
    USER_EMAIL("userEmail"),
    USER_PASSWORD("userPassword");

    private final String user;

    EUser(String user) {this.user = user;}

    public String getUser() {return user;}
}
