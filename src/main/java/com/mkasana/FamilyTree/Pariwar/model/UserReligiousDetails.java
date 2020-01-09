package com.mkasana.FamilyTree.Pariwar.model;

public class UserReligiousDetails {
    int IdReligious;
    Religion religion;
    Caste caste;
    SubCaste subCaste;

    public UserReligiousDetails() {

    }

    public UserReligiousDetails(int idReligious, Religion religion, Caste caste, SubCaste subCaste) {
        IdReligious = idReligious;
        this.religion = religion;
        this.caste = caste;
        this.subCaste = subCaste;
    }

    public int getIdReligious() {
        return IdReligious;
    }

    public void setIdReligious(int idReligious) {
        IdReligious = idReligious;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public Caste getCaste() {
        return caste;
    }

    public void setCaste(Caste caste) {
        this.caste = caste;
    }

    public SubCaste getSubCaste() {
        return subCaste;
    }

    public void setSubCaste(SubCaste subCaste) {
        this.subCaste = subCaste;
    }

    @Override
    public String toString() {
        return "UserReligiousDetails{" +
                "IdReligious=" + IdReligious +
                ", religion=" + religion +
                ", caste=" + caste +
                ", subCaste=" + subCaste +
                '}';
    }
}
