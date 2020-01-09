package com.mkasana.FamilyTree.Pariwar.model;

public class SessionDetails {

    int userId;
    String username;
    String Token;

    public SessionDetails(int userId, String username, String token) {
        this.userId = userId;
        this.username = username;
        Token = token;
    }

    public SessionDetails() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    @Override
    public String toString() {
        return "SessionDetails{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", Token='" + Token + '\'' +
                '}';
    }
}
