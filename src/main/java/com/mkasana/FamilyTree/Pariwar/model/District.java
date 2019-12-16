package com.mkasana.FamilyTree.Pariwar.model;

public class District {
    int Id;
    int StateId;
    State state;
    String DistrictName;
    int Flag;

    public int getId() {
        return Id;
    }

    public District(int id, int stateId, String districtName, int flag, State stateIn) {
        Id = id;
        StateId = stateId;
        DistrictName = districtName;
        Flag = flag;
        state = stateIn;
    }


    @Override
    public String toString() {
        return "District{" +
                "Id=" + Id +
                ", StateId=" + StateId +
                ", state=" + state +
                ", DistrictName='" + DistrictName + '\'' +
                ", Flag=" + Flag +
                '}';
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
