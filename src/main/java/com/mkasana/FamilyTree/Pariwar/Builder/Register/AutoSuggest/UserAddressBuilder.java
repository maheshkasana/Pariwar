package com.mkasana.FamilyTree.Pariwar.Builder.Register.AutoSuggest;

import com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.UserCountryDao;
import com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.UserReligionDao;
import com.mkasana.FamilyTree.Pariwar.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Configurable
@Component
public class UserAddressBuilder {

    @Autowired
    public UserCountryDao userCountryDao;



    /********************************************
     * All the below Builders are for Country   *
     ********************************************/

    /**
     * This function is to return Country for Country Id
     * @param id
     * @return
     */
    public Country getCountryById(final int id) {
        final String function = "UserAddressBuilder:getCountryById";

        ResultSet resultSet;
        Country country = new Country();
        try {
            resultSet = userCountryDao.getUserCountryById(id);
            if(resultSet.next()) {
                country.setId(resultSet.getInt("Id"));
                country.setCountryName(resultSet.getString("CountryName"));
                country.setCountryCode(resultSet.getString("CountryCode"));
            }
            //Todo Convert the result set to the religion
        } catch(Exception e) {
            System.out.println(e);
        }
        return country;
    }

    /**
     * This function is to return All Country
     * @param
     * @return
     */
    public List<Country> getAllCountries() {
        final String function = "UserAddressBuilder:getAllCountries";

        ResultSet resultSet;
        List<Country> countries = new ArrayList<>();
        try {
            resultSet = userCountryDao.getUserAllCountries();
            while(resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getInt("Id"));
                country.setCountryName(resultSet.getString("CountryName"));
                country.setCountryCode(resultSet.getString("CountryCode"));
                countries.add(country);
            }
            //Todo Convert the result set to the religion
        } catch(Exception e) {
            System.out.println(e);
        }
        return countries;
    }


    /**
     * This function is to Create new Country
     * @param
     */
    public ReturnStatus createNewCountry(final Country country) {
        final String function = "UserAddressBuilder:createNewCountry";
        ReturnStatus returnStatus = new ReturnStatus();

        try {
            userCountryDao.createNewCountry(country);
            returnStatus.setErrorCode("");
            returnStatus.setStatusCode(0);
        } catch(Exception e) {
            returnStatus.setErrorCode("Failed to create the new Country");
            returnStatus.setStatusCode(-1);
            System.out.println(function + " Error : "+ e);
        }
        return returnStatus;
    }


    /**
     * This function is to Create new State
     * @param
     */
    public ReturnStatus createNewState(final State state) {

        final String function = "UserAddressBuilder:createNewState";
        ReturnStatus returnStatus = new ReturnStatus();

        try {
            userCountryDao.createNewState(state);
            returnStatus.setErrorCode("");
            returnStatus.setStatusCode(0);
        } catch(Exception e) {
            returnStatus.setErrorCode("Failed to create the new state");
            returnStatus.setStatusCode(-1);
            System.out.println(function + " Error : "+ e);
        }
        return returnStatus;
    }


    /**
     * This function is to Create new District
     * @param
     */
    public ReturnStatus createNewDistrict(final District district)  {
        final String function = "UserAddressBuilder:createNewDistrict";
        ReturnStatus returnStatus = new ReturnStatus();

        try {
            userCountryDao.createNewDistrict(district);
            returnStatus.setErrorCode("");
            returnStatus.setStatusCode(0);
        } catch(Exception e) {
            returnStatus.setErrorCode("Failed to create the new District");
            returnStatus.setStatusCode(-1);
            System.out.println(function + " Error : "+ e);
        }
        return returnStatus;
    }

    /**
     * This function is to Create new Village Town
     * @param
     */
    public ReturnStatus createNewVillageTown(final VillageTown villageTown) {
        final String function = "UserAddressBuilder:createNewVillageTown";

        ReturnStatus returnStatus = new ReturnStatus();

        try {
            userCountryDao.createNewVillageTown(villageTown);
            returnStatus.setErrorCode("");
            returnStatus.setStatusCode(0);
        } catch(Exception e) {
            returnStatus.setErrorCode("Failed to create the new VillageTown");
            returnStatus.setStatusCode(-1);
            System.out.println(function + " Error : "+ e);
        }
        return returnStatus;
    }


    /**
     * this is to Update Village Town PinCode in Address
     * @param villageTown
     * @return
     */
    public ReturnStatus updateVillageTownPinCode(final VillageTown villageTown) {
        final String function = "UserAddressBuilder:updateVillageTownPinCode";

        ReturnStatus returnStatus = new ReturnStatus();

        try {
            userCountryDao.updateVillageTownPinCode(villageTown);
            returnStatus.setErrorCode("");
            returnStatus.setStatusCode(0);
        } catch(Exception e) {
            returnStatus.setErrorCode("Failed to update PinCode in VillageTown");
            returnStatus.setStatusCode(-1);
            System.out.println(function + " Error : "+ e);
        }
        return returnStatus;
    }

    /**
     * this function is to return State by passed Id
     * @param stateId
     * @return
     */
    public State getStateById(final int stateId) {
        final String function = "UserAddressBuilder:getStateById";

        ResultSet resultSet;
        State state = new State();
        try {
            resultSet = userCountryDao.getStateById(stateId);
            if(resultSet.next()) {
                state.setId(resultSet.getInt("Id"));
                state.setCountryId(resultSet.getInt("CountryId"));
                state.setStateName(resultSet.getString("StateName"));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return state;
    }


    /**
     * this function is to return All States
     * @param
     * @return
     */
    public List<State> getAllState() {
        final String function = "UserAddressBuilder:getAllState";

        ResultSet resultSet;
        List<State> states = new ArrayList<>();
        try {
            resultSet = userCountryDao.getAllState();
            while(resultSet.next()) {
                State state = new State();
                state.setId(resultSet.getInt("Id"));
                state.setCountryId(resultSet.getInt("CountryId"));
                state.setStateName(resultSet.getString("StateName"));
                states.add(state);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return states;
    }

    /**
     * this function is to return District by Id
     * @param
     * @return
     */
    public District getDistrictById(final int districtId) {
        final String function = "UserAddressBuilder:getDistrictById";

        ResultSet resultSet;
        District district = new District();
        try {
            resultSet = userCountryDao.getDistrictById(districtId);
            if(resultSet.next()) {
                district.setId(resultSet.getInt("Id"));
                district.setStateId(resultSet.getInt("StateId"));
                district.setDistrictName(resultSet.getString("DistrictName"));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return district;
    }

    /**
     * this function is to return All District
     * @param
     * @return
     */
    public List<District> getAllDistrict() {
        final String function = "UserAddressBuilder:getAllDistrict";

        ResultSet resultSet;
        List<District> districts = new ArrayList<>();
        try {
            resultSet = userCountryDao.getAllDistrict();
            while(resultSet.next()) {
                District district = new District();
                district.setId(resultSet.getInt("Id"));
                district.setStateId(resultSet.getInt("StateId"));
                district.setDistrictName(resultSet.getString("DistrictName"));
                districts.add(district);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return districts;
    }

    /**
     * this function is to return VillageTown by Id
     * @param
     * @return
     */
    public VillageTown getVillageTownById(final int villageTownId) {
        final String Function = "UserAddressBuilder:getVillageTownById";

        ResultSet resultSet;
        VillageTown villageTown = new VillageTown();
        try {
            resultSet = userCountryDao.getVillageTownById(villageTownId);
            if(resultSet.next()) {
                villageTown.setId(resultSet.getInt("Id"));
                villageTown.setDistrictId(resultSet.getInt("DistrictId"));
                villageTown.setVillageTownLocalAreaName(resultSet.getString("VillageTownLocalAreaName"));
                villageTown.setPinCode(resultSet.getInt("PinCode"));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return villageTown;
    }

    /**
     * this function is to return All VillageTown
     * @param
     * @return
     */
    public List<VillageTown> getAllVillageTown() {
        final String function = "UserAddressBuilder:getAllVillageTown";

        ResultSet resultSet;
        List<VillageTown> villageTowns = new ArrayList<>();
        try {
            resultSet = userCountryDao.getAllVillageTown();
            while(resultSet.next()) {
                VillageTown villageTown = new VillageTown();
                villageTown.setId(resultSet.getInt("Id"));
                villageTown.setDistrictId(resultSet.getInt("DistrictId"));
                villageTown.setVillageTownLocalAreaName(resultSet.getString("VillageTownLocalAreaName"));
                villageTown.setPinCode(resultSet.getInt("PinCode"));
                villageTowns.add(villageTown);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return villageTowns;
    }


    /**
     * this function is to return All VillageTown based on the CountryId, District Id, or StateId
     * @param
     * @return
     */
    public List<VillageTown> getAllVillageTownByDistrictIdStateIdCountryId(final int countryId, final int stateId, final int districtId) {
        final String function = "UserAddressBuilder:getAllVillageTown";

        ResultSet resultSet;
        List<VillageTown> villageTowns = new ArrayList<>();
        try {
            resultSet = userCountryDao.getAllVillageTown();
            while(resultSet.next()) {
                VillageTown villageTown = new VillageTown();
                villageTown.setId(resultSet.getInt("Id"));
                villageTown.setDistrictId(resultSet.getInt("DistrictId"));
                villageTown.setVillageTownLocalAreaName(resultSet.getString("VillageTownLocalAreaName"));
                villageTown.setPinCode(resultSet.getInt("PinCode"));
                villageTowns.add(villageTown);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return villageTowns;
    }

}
