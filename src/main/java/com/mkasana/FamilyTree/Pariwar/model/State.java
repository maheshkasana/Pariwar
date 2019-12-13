package com.mkasana.FamilyTree.Pariwar.model;

public class State {
    int Id;
    int CountryId;
    int StateCode;
    int StateName;

    public State(int id, int countryId, int stateName, int stateCode) {
        Id = id;
        CountryId = countryId;
        StateName = stateName;
        StateCode = stateCode;
    }

    public State() {
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
    }

    public int getStateCode() {
        return StateCode;
    }

    public void setStateCode(int stateCode) {
        StateCode = stateCode;
    }

    public int getStateName() {
        return StateName;
    }

    public void setStateName(int stateName) {
        StateName = stateName;
    }

    @Override
    public String toString() {
        return "State{" +
                "Id=" + Id +
                ", CountryId=" + CountryId +
                ", StateCode=" + StateCode +
                ", StateName=" + StateName +
                '}';
    }
}
