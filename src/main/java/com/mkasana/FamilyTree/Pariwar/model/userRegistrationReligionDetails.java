package com.mkasana.FamilyTree.Pariwar.model;

public class userRegistrationReligionDetails {
    int religion;
    int caste;
    int subCaste;

    public userRegistrationReligionDetails(int religion, int caste, int subCaste) {
        this.religion = religion;
        this.caste = caste;
        this.subCaste = subCaste;
    }

    public userRegistrationReligionDetails() {
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

    public int getSubCaste() {
        return subCaste;
    }

    public void setSubCaste(int subCaste) {
        this.subCaste = subCaste;
    }

    @Override
    public String toString() {
        return "userRegistrationReligionDetails{" +
                "religion=" + religion +
                ", caste=" + caste +
                ", subCaste=" + subCaste +
                '}';
    }
}