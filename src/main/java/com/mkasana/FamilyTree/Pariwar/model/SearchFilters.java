package com.mkasana.FamilyTree.Pariwar.model;

public class SearchFilters {

    public String name;
    public int state;
    public int district;
    public int tehsil;
    public int village;
    public int religion;
    public int caste;
    public int subcaste;

    public SearchFilters(String name, int state, int district, int tehsil, int village, int religion, int caste, int subcaste) {
        this.name = name;
        this.state = state;
        this.district = district;
        this.tehsil = tehsil;
        this.village = village;
        this.religion = religion;
        this.caste = caste;
        this.subcaste = subcaste;
    }

    public SearchFilters() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getTehsil() {
        return tehsil;
    }

    public void setTehsil(int tehsil) {
        this.tehsil = tehsil;
    }

    public int getVillage() {
        return village;
    }

    public void setVillage(int village) {
        this.village = village;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    public int getCaste() {
        return caste;
    }

    public void setCaste(int caste) {
        this.caste = caste;
    }

    public int getSubcaste() {
        return subcaste;
    }

    public void setSubcaste(int subcaste) {
        this.subcaste = subcaste;
    }

    @Override
    public String toString() {
        return "SearchFilters{" +
                "name='" + name + '\'' +
                ", state=" + state +
                ", district=" + district +
                ", tehsil=" + tehsil +
                ", village=" + village +
                ", religion=" + religion +
                ", caste=" + caste +
                ", subcaste=" + subcaste +
                '}';
    }
}
