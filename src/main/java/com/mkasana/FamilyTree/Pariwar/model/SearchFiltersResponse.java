package com.mkasana.FamilyTree.Pariwar.model;

public class SearchFiltersResponse {
    public int userid;
    public String name;
    public String username;
    public int gender;
    public String localaddress;
    public String religion;
    public String address;

    public SearchFiltersResponse(int userid, String name, String username, int gender, String localaddress, String religion, String address) {
        this.userid = userid;
        this.name = name;
        this.username = username;
        this.gender = gender;
        this.localaddress = localaddress;
        this.religion = religion;
        this.address = address;
    }

    public SearchFiltersResponse() {}

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getLocaladdress() {
        return localaddress;
    }

    public void setLocaladdress(String localaddress) {
        this.localaddress = localaddress;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SearchFiltersResponse{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", localaddress='" + localaddress + '\'' +
                ", religion='" + religion + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
