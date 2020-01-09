package com.mkasana.FamilyTree.Pariwar.model;

public class LoginResponse {

    private String username;
    private String authKey;
    private int userId;
    private Boolean status;
    private String msg;

    public LoginResponse(String username, String authKey, int userId, Boolean status, String msg) {
        this.username = username;
        this.authKey = authKey;
        this.userId = userId;
        this.status = status;
        this.msg = msg;
    }

    public LoginResponse() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
                "username='" + username + '\'' +
                ", authKey='" + authKey + '\'' +
                ", userId=" + userId +
                ", status=" + status +
                ", msg='" + msg + '\'' +
                '}';
    }
}
