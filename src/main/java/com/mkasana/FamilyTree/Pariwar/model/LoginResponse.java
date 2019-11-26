package com.mkasana.FamilyTree.Pariwar.model;

public class LoginResponse {

    private String userName;
    private String AuthToken;
    private int id;

    @Override
    public String toString() {
        return "LoginResponse{" +
                "userName='" + userName + '\'' +
                ", AuthTocken='" + AuthToken + '\'' +
                ", id=" + id +
                '}';
    }

    public LoginResponse() {
    }

    public LoginResponse(String userName, String authToken, int id) {
        this.userName = userName;
        AuthToken = authToken;
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthToken() {
        return AuthToken;
    }

    public void setAuthToken(String authToken) {
        AuthToken = authToken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
