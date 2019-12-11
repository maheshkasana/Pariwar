package com.mkasana.FamilyTree.Pariwar.model;

public class Caste {

    int Id;
    String UserCasteName;
    int UserReligionId;

    public Caste(int id, String userCasteName, int userReligionId) {
        Id = id;
        UserCasteName = userCasteName;
        UserReligionId = userReligionId;
    }

    public Caste() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserCasteName() {
        return UserCasteName;
    }

    public void setUserCasteName(String userCasteName) {
        UserCasteName = userCasteName;
    }

    public int getUserReligionId() {
        return UserReligionId;
    }

    public void setUserReligionId(int userReligionId) {
        UserReligionId = userReligionId;
    }

    @Override
    public String toString() {
        return "Caste{" +
                "Id=" + Id +
                ", UserCasteName='" + UserCasteName + '\'' +
                ", UserReligionId=" + UserReligionId +
                '}';
    }
}

