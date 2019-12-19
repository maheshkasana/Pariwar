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
     * this is to Create New Teshil in Address
     * @param tehsil
     * @return
     */
    @Override
    public ReturnStatus createNewTehsil(final Tehsil tehsil) {
        String Function = "UserAddressComponentImpl:createNewTehsil";

        return userAddressBuilder.createNewTehsil(tehsil);
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

    /**
     * this is to Update Village Town PinCode in Address
     * @param villageTown
     * @return
     */
    @Override
    public ReturnStatus updateVillageTownPinCode(final VillageTown villageTown) {
        String Function = "UserAddressComponentImpl:updateVillageTownPinCode";

        return userAddressBuilder.updateVillageTownPinCode(villageTown);
    }


    /**
     * this function is to return State by passed Id
     * @param stateId
     * @return
     */
    public State getStateById(final int stateId) {
        String Function = "UserAddressComponentImpl:getStateById";
        Country country;
        State state = userAddressBuilder.getStateById(stateId);
        country = userAddressBuilder.getCountryById(state.getCountryId());
        state.setCountry(country);
        return state;
    }


    /**
     * this function is to return All States
     * @param
     * @return
     */
    public List<State> getAllState() {
        String Function = "UserAddressComponentImpl:getAllState";

        return userAddressBuilder.getAllState();
    }

    /**
     * this function is to return District by Id
     * @param
     * @return
     */
    public District getDistrictById(final int districtId) {
        String Function = "UserAddressComponentImpl:getDistrictById";
        District district =  userAddressBuilder.getDistrictById(districtId);
        State state = getStateById(district.getStateId());
        district.setState(state);

        return district;
    }

    /**
     * this function is to return All District
     * @param
     * @return
     */
    public List<District> getAllDistrict() {
        String Function = "UserAddressComponentImpl:getAllDistrict";

        return userAddressBuilder.getAllDistrict();
    }

    /**
     * this function is to return All District by state id
     * @param
     * @return
     */
    public List<District> suggestDistrictByStateId(final int stateId) {
        String Function = "UserAddressComponentImpl:suggestDistrictByStateId";

        return userAddressBuilder.suggestDistrictByStateId(stateId);
    }

    /****************************************************
     *  All the below Controllers are for Teshil   *
     ****************************************************/

    /**
     * this function is to return tehsilId by Id
     * @param tehsilId
     * @return
     */
    public Tehsil getTehsilById(final int tehsilId) {
        String Function = "UserAddressComponentImpl:getTehsilById";
        Tehsil tehsil = userAddressBuilder.getTehsilById(tehsilId);
        District district = getDistrictById(tehsil.getDistrictId());
        tehsil.setDistrict(district);
        return tehsil;
    }

    /**
     * this function is to return All Tehsil;
     * @param
     * @return
     */
    public List<Tehsil> getAllTehsil() {
        String Function = "UserAddressComponentImpl:getAllTehsil";

        return userAddressBuilder.getAllTehsil();
    }

    /**
     * this function is to return All Tehsil by District Id;
     * @param districtId
     * @return
     */
    public List<Tehsil> getAllTehsilByDistrictId(final int districtId) {
        String Function = "UserAddressComponentImpl:getAllTehsilByDistrictId";

        return userAddressBuilder.getAllTehsilByDistrictId(districtId);
    }



    /**
     * this function is to return VillageTown by Id
     * @param
     * @return
     */
    public VillageTown getVillageTownById(final int villageTownId) {
        String Function = "UserAddressComponentImpl:getVillageTownById";
        VillageTown villageTown = userAddressBuilder.getVillageTownById(villageTownId);
        Tehsil tehsil = getTehsilById(villageTown.getTehsilId());
        villageTown.setTehsil(tehsil);
        return villageTown;
    }

    /**
     * this function is to return All VillageTown
     * @param
     * @return
     */
    public List<VillageTown> getAllVillageTown() {
        String Function = "UserAddressComponentImpl:getAllVillageTown";

        return userAddressBuilder.getAllVillageTown();
    }

    /**
     * this function is to return All VillageTown by TehSil Id
     * @param
     * @return
     */
    public List<VillageTown> getAllVillageTownByTehsilId(final int tehsilId)  {
        String Function = "UserAddressComponentImpl:getAllVillageTownByTehsilId";

        return userAddressBuilder.getAllVillageTownByTehsilId(tehsilId);
    }


}

