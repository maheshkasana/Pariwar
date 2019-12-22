package com.mkasana.FamilyTree.Pariwar.model;

public class userRegistrationRequest {

    String username;
    String password;
    String firstname;
    int  gender;
    String dateofbirth;
    String profilepic;
    userRegistrationAddressDetails address;
    userRegistrationReligionDetails religious;
    userRegistrationContactDetails contact;

    public userRegistrationRequest(String username, String password, String firstname, int gender, String dateofbirth, String profilepic, userRegistrationAddressDetails address, userRegistrationReligionDetails religious, userRegistrationContactDetails contact) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.gender = gender;
        this.dateofbirth = dateofbirth;
        this.profilepic = profilepic;
        this.address = address;
        this.religious = religious;
        this.contact = contact;
    }

    public userRegistrationRequest() {
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public userRegistrationAddressDetails getAddress() {
        return address;
    }

    public void setAddress(userRegistrationAddressDetails address) {
        this.address = address;
    }

    public userRegistrationReligionDetails getReligious() {
        return religious;
    }

    public void setReligious(userRegistrationReligionDetails religious) {
        this.religious = religious;
    }

    public userRegistrationContactDetails getContact() {
        return contact;
    }

    public void setContact(userRegistrationContactDetails contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "userRegistrationRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", gender=" + gender +
                ", dateofbirth='" + dateofbirth + '\'' +
                ", profilepic='" + profilepic + '\'' +
                ", address=" + address +
                ", religious=" + religious +
                ", contact=" + contact +
                '}';
    }
}
