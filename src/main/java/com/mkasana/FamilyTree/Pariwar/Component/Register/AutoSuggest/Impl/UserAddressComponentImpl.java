package com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest.Impl;

import com.mkasana.FamilyTree.Pariwar.Builder.Register.AutoSuggest.UserAddressBuilder;
import com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest.UserAddressComponent;
import com.mkasana.FamilyTree.Pariwar.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

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


    /**
     * This function is to Create new Country
     * @param
     */
    @Override
    public ReturnStatus createNewCountry(final Country country) {
        String Function = "UserAddressComponentImpl:createNewCountry";

        return userAddressBuilder.createNewCountry(country);
    }


    /**
     * This function is to Create new State
     * @param
     */
    @Override
    public ReturnStatus createNewState(final State state) {
        String Function = "UserAddressComponentImpl:createNewState";

        return userAddressBuilder.createNewState(state);
    }

    /**
     * this is to Create New District in Address
     * @param district
     * @return
     */
    @Override
    public ReturnStatus createNewDistrict(final District district) {
        String Function = "UserAddressComponentImpl:createNewDistrict";

        return userAddressBuilder.createNewDistrict(district);
    }

    /**
     * this is to Create New District in Address
     * @param villageTown
     * @return
     */
    @Override
    public ReturnStatus createNewVillageTown(final VillageTown villageTown) {
        String Function = "UserAddressComponentImpl:createNewVillageTown";

        return userAddressBuilder.createNewVillageTown(villageTown);
    }


}
