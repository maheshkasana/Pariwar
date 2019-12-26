package com.mkasana.FamilyTree.Pariwar.model;

public class LoginRequestBody {
    private String username;
    private String password;
    private int remember;

    public LoginRequestBody(String username, String password, int remember) {
        this.username = username;
        this.password = password;
        this.remember = remember;
    }

    public LoginRequestBody() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRemember() {
        return remember;
    }

    public void setRemember(int remember) {
        this.remember = remember;
    }

    @Override
    public String toString() {
        return "LoginRequestBody{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", remember=" + remember +
                '}';
    }
}
