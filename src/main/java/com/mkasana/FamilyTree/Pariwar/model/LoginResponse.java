package com.mkasana.FamilyTree.Pariwar.model;

public class LoginResponse {

    private String userName;
    private String AuthTocken;
    private int id;

    @Override
    public String toString() {
        return "LoginResponse{" +
                "userName='" + userName + '\'' +
                ", AuthTocken='" + AuthTocken + '\'' +
                ", id=" + id +
                '}';
    }

    public LoginResponse() {
    }

    public LoginResponse(String userName, String authTocken, int id) {
        this.userName = userName;
        AuthTocken = authTocken;
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthTocken() {
        return AuthTocken;
    }

    public void setAuthTocken(String authTocken) {
        AuthTocken = authTocken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
