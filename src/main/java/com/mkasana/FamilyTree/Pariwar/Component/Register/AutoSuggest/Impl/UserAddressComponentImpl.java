package com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest.Impl;

import com.mkasana.FamilyTree.Pariwar.Builder.Register.AutoSuggest.UserAddressBuilder;
import com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest.UserAddressComponent;
import com.mkasana.FamilyTree.Pariwar.model.Country;
import com.mkasana.FamilyTree.Pariwar.model.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAddressComponentImpl implements UserAddressComponent {


    @Autowired
    public UserAddressBuilder userAddressBuilder;



    /********************************************
     * All the below Component are for Religion *
     *******************************************/

    /**
     * This function is to return the Country by Id
     * @param id
     */
    @Override
    public Country getCountryById(final int id) {
        String Function = "UserAddressComponentImpl:getCountryById";

        return userAddressBuilder.getCountryById(id);
    }


    /**
     * This function is to return the Country By Name
     * @param name
     */
    @Override
    public Country getCountryByName(String name) {
        return null;
    }


    /**
     * This function is to return the All Countries
     * @param
     */
    @Override
    public List<Country> getAllCountries() {
        String Function = "UserAddressComponentImpl:getAllCountries";

        return userAddressBuilder.getAllCountries();
    }


    /**
     * This function is to Add new Country
     * @param
     */
    @Override
    public ReturnStatus addNewCountry(Country country) {
        return null;
    }


    /**
     * This function is to delete the country
     * @param
     */
    @Override
    public ReturnStatus deleteCountry(Country country) {
        return null;
    }

}
