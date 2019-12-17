package com.mkasana.FamilyTree.Pariwar.model;

public class SubCaste {
    int Id;
    String UserSubCasteName;
    int UserCasteId;
    int UserReligionId;
    String UserCasteName;
    String ReligionName;
    Caste caste;

    public SubCaste(int id, String userSubcasteName, int userCasteId, int userReligionId, String userCasteName, String religionName, Caste casteIn) {
        Id = id;
        UserSubCasteName = userSubcasteName;
        UserCasteId = userCasteId;
        UserReligionId = userReligionId;
        UserCasteName = userCasteName;
        ReligionName = religionName;
        caste = casteIn;
    }

    @Override
    public String toString() {
        return "SubCaste{" +
                "Id=" + Id +
                ", UserSubCasteName='" + UserSubCasteName + '\'' +
                ", UserCasteId=" + UserCasteId +
                ", UserReligionId=" + UserReligionId +
                ", UserCasteName='" + UserCasteName + '\'' +
                ", ReligionName='" + ReligionName + '\'' +
                ", caste=" + caste +
                '}';
    }

    public SubCaste() {
    }

    public Caste getCaste() {
        return caste;
    }

    public void setCaste(Caste caste) {
        this.caste = caste;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserSubCasteName() {
        return UserSubCasteName;
    }

    public void setUserSubCasteName(String userSubCasteName) {
        UserSubCasteName = userSubCasteName;
    }

    public int getUserCasteId() {
        return UserCasteId;
    }

    public void setUserCasteId(int userCasteId) {
        UserCasteId = userCasteId;
    }

    public int getUserReligionId() {
        return UserReligionId;
    }

    public void setUserReligionId(int userReligionId) {
        UserReligionId = userReligionId;
    }

    public String getUserCasteName() {
        return UserCasteName;
    }

    public void setUserCasteName(String userCasteName) {
        UserCasteName = userCasteName;
    }

    public String getReligionName() { return ReligionName; }

    public void setReligionName(String religionName) {
        ReligionName = religionName;
    }

}
