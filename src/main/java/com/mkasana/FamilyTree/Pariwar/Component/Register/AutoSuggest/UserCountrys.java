package com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest;

import com.mkasana.FamilyTree.Pariwar.model.Country;
import com.mkasana.FamilyTree.Pariwar.model.ReturnStatus;

import java.util.List;

public interface UserCountrys {
    /**
     * This function is to return the Country by Id
     * @param id
     */
    public Country getCountryById(int id);

    /**
     * This String is to return the Country by Name
     * @param name
     * @return
     */
    public Country getCountryByName(String name);


    /**
     * this function is to return the all the countries
     * @return
     */
    public List<Country> getAllCountries();


    /**
     * this is to add new Country.
     * @param country
     * @return
     */
    public ReturnStatus addNewCountry(Country country);

    /**
     * this is to delete a Country
     * @param country
     * @return
     */
    public ReturnStatus deleteCountry(Country country);

}
