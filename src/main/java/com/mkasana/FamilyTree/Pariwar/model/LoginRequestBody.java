package com.mkasana.FamilyTree.Pariwar.model;

public class LoginRequestBody {
    private String username;
    private String password;

    public LoginRequestBody(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginRequestBody() {

    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "<LoginRequestBody>" +
                    "<username>" + username + "</username>" +
                    "<password>" + password + "</password>" +
                "</LoginRequestBody>";
    }
}
