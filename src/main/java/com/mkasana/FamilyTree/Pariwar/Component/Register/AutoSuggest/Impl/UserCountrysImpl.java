package com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest.Impl;

import com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest.UserCountrys;
import com.mkasana.FamilyTree.Pariwar.dao.DatabaseConnection;
import com.mkasana.FamilyTree.Pariwar.model.Country;
import com.mkasana.FamilyTree.Pariwar.model.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserCountrysImpl implements UserCountrys {

    @Autowired
    DatabaseConnection databaseConnection;

    public Country getCountryById(int id) {

        String query = "SELECT * FROM ";

        //Todo

        return null;
    }


    public Country getCountryByName(String name) {
        return null;
    }


    public List<Country> getAllCountries() {
        return null;
    }


    public ReturnStatus addNewCountry(Country country) {
        return null;
    }


    public ReturnStatus deleteCountry(Country country) {
        return null;
    }

}
