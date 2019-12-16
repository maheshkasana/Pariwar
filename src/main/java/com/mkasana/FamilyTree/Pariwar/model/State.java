package com.mkasana.FamilyTree.Pariwar.model;

public class State {
    int Id;
    int CountryId;
    int StateCode;
    String StateName;
    Country country;


    public State(int id, int countryId, String stateName, int stateCode, Country countryIn) {
        Id = id;
        CountryId = countryId;
        StateName = stateName;
        StateCode = stateCode;
        country = countryIn;
    }

    public State() {
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    @Override
    public String toString() {
        return "State{" +
                "Id=" + Id +
                ", CountryId=" + CountryId +
                ", StateCode=" + StateCode +
                ", StateName='" + StateName + '\'' +
                ", country=" + country +
                '}';
    }
}
