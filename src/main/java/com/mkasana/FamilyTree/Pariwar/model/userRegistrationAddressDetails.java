package com.mkasana.FamilyTree.Pariwar.model;

public class userRegistrationAddressDetails {
    String locality;
    int village;
    int tehsil;
    int district;
    int state;

    public userRegistrationAddressDetails(String locality, int village, int tehsil, int district, int state) {
        this.locality = locality;
        this.village = village;
        this.tehsil = tehsil;
        this.district = district;
        this.state = state;
    }

    public userRegistrationAddressDetails() {
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public int getVillage() {
        return village;
    }

    public void setVillage(int village) {
        this.village = village;
    }

    public int getTehsil() {
        return tehsil;
    }

    public void setTehsil(int tehsil) {
        this.tehsil = tehsil;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "userRegistrationAddressDetails{" +
                "locality='" + locality + '\'' +
                ", village=" + village +
                ", tehsil=" + tehsil +
                ", district=" + district +
                ", state=" + state +
                '}';
    }
}
