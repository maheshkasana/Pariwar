package com.mkasana.FamilyTree.Pariwar.model;

public class UserAddressDetails {

    int IdAddress;
    Country country;
    State state;
    District district;
    Tehsil tehsil;
    VillageTown villageTown;
    String locality;


    public UserAddressDetails() {}

    public UserAddressDetails(int idAddress, Country country, State state, District district, Tehsil tehsil, VillageTown villageTown, String locality) {
        IdAddress = idAddress;
        this.country = country;
        this.state = state;
        this.district = district;
        this.tehsil = tehsil;
        this.villageTown = villageTown;
        this.locality = locality;
    }

    public int getIdAddress() {
        return IdAddress;
    }

    public void setIdAddress(int idAddress) {
        IdAddress = idAddress;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Tehsil getTehsil() {
        return tehsil;
    }

    public void setTehsil(Tehsil tehsil) {
        this.tehsil = tehsil;
    }

    public VillageTown getVillageTown() {
        return villageTown;
    }

    public void setVillageTown(VillageTown villageTown) {
        this.villageTown = villageTown;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @Override
    public String toString() {
        return "UserAddressDetails{" +
                "IdAddress=" + IdAddress +
                ", country=" + country +
                ", state=" + state +
                ", district=" + district +
                ", tehsil=" + tehsil +
                ", villageTown=" + villageTown +
                ", locality='" + locality + '\'' +
                '}';
    }
}
