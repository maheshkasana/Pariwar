package com.mkasana.FamilyTree.Pariwar.model;

public class Caste {

    int Id;
    String UserCasteName;
    int UserReligionId;
    String ReligionName;

    public Caste(int id, String userCasteName, int userReligionId) {
        Id = id;
        UserCasteName = userCasteName;
        UserReligionId = userReligionId;
    }

    public Caste(int id, String userCasteName, int userReligionId, String religionName) {
        Id = id;
        UserCasteName = userCasteName;
        UserReligionId = userReligionId;
        ReligionName = religionName;
    }

    public String getReligionName() {
        return ReligionName;
    }

    public void setReligionName(String religionName) {
        ReligionName = religionName;
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
                ", ReligionName='" + ReligionName + '\'' +
                '}';
    }
}

