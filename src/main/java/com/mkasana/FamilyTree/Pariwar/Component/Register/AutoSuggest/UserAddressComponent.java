package com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest;

import com.mkasana.FamilyTree.Pariwar.model.*;

import java.util.List;

public interface UserAddressComponent {
    /**
     * This function is to return the Country by Id
     * @param id
     */
    public Country getCountryById(final int id);

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


    /**
     * this is to Create New Country in Address
     * @param country
     * @return
     */
    public ReturnStatus createNewCountry(final Country country);

    /**
     * this is to Create New State in Address
     * @param state
     * @return
     */
    public ReturnStatus createNewState(final State state);


    /**
     * this is to Create New District in Address
     * @param district
     * @return
     */
    public ReturnStatus createNewDistrict(final District district);


    /**
     * this is to Create New Village Town in Address
     * @param villageTown
     * @return
     */
    public ReturnStatus createNewVillageTown(final VillageTown villageTown);


}
