package com.mkasana.FamilyTree.Pariwar.model;

public class LoginResponse {

    private String userName;
    private String AuthToken;
    private int id;
    private Boolean status;

    @Override
    public String toString() {
        return "LoginResponse{" +
                "userName='" + userName + '\'' +
                ", AuthToken='" + AuthToken + '\'' +
                ", id=" + id + '\'' +
                ", status=" + status +
                '}';
    }

    public LoginResponse() {
    }

    public LoginResponse(String userName, String authToken, int id, Boolean status) {
        this.userName = userName;
        this.AuthToken = authToken;
        this.id = id;
        this.status = status;
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

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return this.status;
    }

}
