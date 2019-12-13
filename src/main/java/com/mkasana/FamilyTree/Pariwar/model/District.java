package com.mkasana.FamilyTree.Pariwar.model;

public class District {
    int Id;
    int StateId;

    public int getId() {
        return Id;
    }

    public District(int id, int stateId, String districtName, int flag) {
        Id = id;
        StateId = stateId;
        DistrictName = districtName;
        Flag = flag;
    }

    @Override
    public String toString() {
        return "District{" +
                "Id=" + Id +
                ", StateId=" + StateId +
                ", DistrictName='" + DistrictName + '\'' +
                ", Flag=" + Flag +
                '}';
    }

    public void setId(int id) {
        Id = id;
    }

    String DistrictName;
    int Flag;

    public District(int stateId, String districtName, int flag) {
        StateId = stateId;
        DistrictName = districtName;
        Flag = flag;
    }

    public District() {
    }

    public int getStateId() {
        return StateId;
    }

    public void setStateId(int stateId) {
        StateId = stateId;
    }

    public String getDistrictName() {
        return DistrictName;
    }

    public void setDistrictName(String districtName) {
        DistrictName = districtName;
    }

    public int getFlag() {
        return Flag;
    }

    public void setFlag(int flag) {
        Flag = flag;
    }

}
