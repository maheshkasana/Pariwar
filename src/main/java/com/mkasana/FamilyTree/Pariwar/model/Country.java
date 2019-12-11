package com.mkasana.FamilyTree.Pariwar.model;

public class Country {
    int Id;
    String CountryName;
    String CountryCode;

    public Country(int id, String countryName, String countryCode) {
        Id = id;
        CountryName = countryName;
        CountryCode = countryCode;
    }

    public Country(int id, String countryName) {
        Id = id;
        CountryName = countryName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Country{" +
                "Id=" + Id +
                ", CountryName='" + CountryName + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                '}';
    }
}
