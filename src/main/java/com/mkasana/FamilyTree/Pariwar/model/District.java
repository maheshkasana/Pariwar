package com.mkasana.FamilyTree.Pariwar.model;

public class District {
    int Id;
    int StateId;
    State state;
    String DistrictName;
    String DistrictCode;
    int Flag;

    public int getId() {
        return Id;
    }

    public District(int id, int stateId, String districtName, int flag, State stateIn, String DistrictCodeIn) {
        Id = id;
        StateId = stateId;
        DistrictName = districtName;
        Flag = flag;
        state = stateIn;
        DistrictCode = DistrictCodeIn;
    }


    @Override
    public String toString() {
        return "District{" +
                "Id=" + Id +
                ", StateId=" + StateId +
                ", state=" + state +
                ", DistrictName='" + DistrictName + '\'' +
                ", DistrictCode='" + DistrictCode + '\'' +
                ", Flag=" + Flag +
                '}';
    }

    public String getDistrictCode() {
        return DistrictCode;
    }

    public void setDistrictCode(String districtCode) {
        DistrictCode = districtCode;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setId(int id) {
        Id = id;
    }



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
