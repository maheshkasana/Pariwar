package com.mkasana.FamilyTree.Pariwar.model;

public class LoginResponse {

    private String userName;
    private String keyId;
    private Boolean status;


    public LoginResponse() {
    }

    public LoginResponse(String userName, String keyId, Boolean status) {
        this.userName = userName;
        this.keyId = keyId;
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "userName='" + userName + '\'' +
                ", keyId='" + keyId + '\'' +
                ", status=" + status +
                '}';
    }
}
