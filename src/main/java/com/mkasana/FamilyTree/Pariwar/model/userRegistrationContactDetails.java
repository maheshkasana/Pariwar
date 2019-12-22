package com.mkasana.FamilyTree.Pariwar.model;

public class userRegistrationContactDetails {
    String emailAddress;
    String phone;

    public userRegistrationContactDetails(String emailAddress, String phone) {
        this.emailAddress = emailAddress;
        this.phone = phone;
    }

    public userRegistrationContactDetails() {
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "userRegistrationContactDetails{" +
                "emailAddress='" + emailAddress + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
