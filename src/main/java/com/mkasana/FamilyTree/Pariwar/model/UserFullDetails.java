package com.mkasana.FamilyTree.Pariwar.model;

public class UserFullDetails {

    int userId;
    String username;
    String password;
    String firstname;
    int  gender;
    String dateofbirth;
    String profilepic;
    userRegistrationContactDetails contactDetails;
    UserReligiousDetails userReligiousDetails;
    UserAddressDetails userAddressDetails;

    public UserFullDetails(int userId, String username, String password, String firstname, int gender, String dateofbirth, String profilepic, userRegistrationContactDetails contactDetails, UserReligiousDetails userReligiousDetails, UserAddressDetails userAddressDetails) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.gender = gender;
        this.dateofbirth = dateofbirth;
        this.profilepic = profilepic;
        this.contactDetails = contactDetails;
        this.userReligiousDetails = userReligiousDetails;
        this.userAddressDetails = userAddressDetails;
    }

    public UserFullDetails() {}

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

    public userRegistrationContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(userRegistrationContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public UserReligiousDetails getUserReligiousDetails() {
        return userReligiousDetails;
    }

    public void setUserReligiousDetails(UserReligiousDetails userReligiousDetails) {
        this.userReligiousDetails = userReligiousDetails;
    }

    public UserAddressDetails getUserAddressDetails() {
        return userAddressDetails;
    }

    public void setUserAddressDetails(UserAddressDetails userAddressDetails) {
        this.userAddressDetails = userAddressDetails;
    }

    @Override
    public String toString() {
        return "UserFullDetails{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", gender=" + gender +
                ", dateofbirth='" + dateofbirth + '\'' +
                ", profilepic='" + profilepic + '\'' +
                ", contactDetails=" + contactDetails +
                ", userReligiousDetails=" + userReligiousDetails +
                ", userAddressDetails=" + userAddressDetails +
                '}';
    }
}
