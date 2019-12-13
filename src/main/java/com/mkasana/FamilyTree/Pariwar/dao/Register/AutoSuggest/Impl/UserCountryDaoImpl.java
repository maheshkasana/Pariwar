package com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.Impl;


import com.mkasana.FamilyTree.Pariwar.dao.DatabaseConnection;
import com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.UserCountryDao;
import com.mkasana.FamilyTree.Pariwar.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.sql.ResultSet;

@Component
@Configurable
public class UserCountryDaoImpl implements UserCountryDao {

    @Autowired
    public DatabaseConnection databaseConnection;


    /********************************************
     * All the below Dao are for Religion *
     *******************************************/

    /**
     * this function is to return the Result set of the query ran on the UserCountryTable
     * @param id
     * @return
     */
    public ResultSet getUserCountryById(final int id) throws Exception {
        String Function = "UserCountryDaoImpl:getUserCountryById";

        String query = "SELECT * FROM CountryDetails WHERE Id = "+id+";";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserCountryDaoImpl:getUserCountryById Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public ResultSet getUserAllCountries() throws Exception {
        String Function = "UserCountryDaoImpl:getUserAllCountries";

        String query = "SELECT * FROM CountryDetails;";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserCountryDaoImpl:getUserAllCountries Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }


    /**
     * this is to Create New Country in Address
     * @param country
     * @return
     */
    @Override
    public void createNewCountry(final Country country) throws Exception {
        String Function = "UserCountryDaoImpl:createNewCountry";

        String query = "INSERT INTO CountryDetails(CountryName, CountryCode, Flag) VALUES \n"
                + "(" + country.getCountryName() + "," + country.getCountryCode() + "," + 1 + ");";
        try {
            databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserCountryDaoImpl:createNewCountry Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }


    /**
     * this is to Create New State in Address
     * @param state
     * @return
     */
    @Override
    public void createNewState(@NotNull final State state) throws Exception {
        String Function = "UserCountryDaoImpl:createNewState";

        String query = "INSERT INTO StateDetails(CountryId, StateName, Flag) VALUES \n"
                        + "(" + state.getCountryId() + "," + state.getStateName() + "," + 1 + ");";
        try {
            databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserCountryDaoImpl:createNewState Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }


    /**
     * this is to Create New District in Address
     * @param district
     * @return
     */
    public void createNewDistrict(final District district) throws Exception {
        String Function = "UserCountryDaoImpl:createNewDistrict";

        String query = "INSERT INTO DistrictDetails(StateId,DistrictName,Flag) VALUES \n"
                + "(" + district.getStateId() + "," + district.getDistrictName() + "," + 1 + ");";
        try {
            databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserCountryDaoImpl:createNewDistrict Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    /**
     * this is to Create New VillageTown in Address
     * @param villageTown
     * @return
     */
    public void createNewVillageTown(final VillageTown villageTown) throws Exception {
        String Function = "UserCountryDaoImpl:createNewVillageTown";

        String query = "INSERT INTO VillageTownLocalAreaDetails(DistrictId, VillageTownLocalAreaName, PinCode, Flag) VALUES \n"
                + "(" + villageTown.getDistrictId() + "," + villageTown.getVillageTownLocalAreaName() + "," + villageTown.getPinCode() + "," + 1 + ");";
        try {
            databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserCountryDaoImpl:createNewVillageTown Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }
}
