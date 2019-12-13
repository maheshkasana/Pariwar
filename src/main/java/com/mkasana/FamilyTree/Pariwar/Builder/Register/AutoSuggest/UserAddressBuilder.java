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
     * All the below Builders are for Country *
     *******************************************/

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
}
