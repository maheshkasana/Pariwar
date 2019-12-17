package com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.Impl;


import com.mkasana.FamilyTree.Pariwar.dao.DatabaseConnection;
import com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.UserCountryDao;
import com.mkasana.FamilyTree.Pariwar.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.sql.ResultSet;
import java.util.List;

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


    /**
     * this function is to return All Countries
     * @param
     * @return
     */
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
                + "('" + country.getCountryName() + "','" + country.getCountryCode() + "'," + 0 + ");";
        try {
            databaseConnection.executeUpdate(query);
            databaseConnection.commit();
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

        String query = "INSERT INTO StateDetails(CountryId, StateName, StateCode, Flag) VALUES \n"
                        + "(" + state.getCountryId() + ",'" + state.getStateName() + "','" + state.getStateCode()  + "'," + 0 + ");";
        try {
            databaseConnection.executeUpdate(query);
            databaseConnection.commit();
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

        String query = "INSERT INTO DistrictDetails(StateId,DistrictName,DistrictCode,Flag) VALUES \n"
                + "(" + district.getStateId() + ",'" + district.getDistrictName() + "','" + district.getDistrictCode() + "'," + 0 + ");";
        try {
            databaseConnection.executeUpdate(query);
            databaseConnection.commit();
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

        String query = "INSERT INTO VillageTownLocalAreaDetails(DistrictId, VillageTownLocalAreaName, VillageTownLocalAreaCode, PinCode, Flag) VALUES \n"
                + "(" + villageTown.getDistrictId() + ",'" + villageTown.getVillageTownLocalAreaName() + "','" + villageTown.getVillageTownLocalAreaCode() + "'," + villageTown.getPinCode() + "," + 0 + ");";
        try {
            databaseConnection.executeUpdate(query);
            databaseConnection.commit();
        } catch(Exception e) {
            String error = "[Error] UserCountryDaoImpl:createNewVillageTown Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    /**
     * this is to Update Village Town PinCode in Address
     * @param villageTown
     * @return
     */
    public void updateVillageTownPinCode(VillageTown villageTown) throws Exception {
        String Function = "UserCountryDaoImpl:updateVillageTownPinCode";

        String query = "UPDATE VillageTownLocalAreaDetails SET PinCode =\n"
                + villageTown.getPinCode() + " WHERE Id = " + villageTown.getId() + ";";
        try {
            databaseConnection.executeUpdate(query);
            databaseConnection.commit();
        } catch(Exception e) {
            String error = "[Error] UserCountryDaoImpl:updateVillageTownPinCode Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }

    }

    /**
     * this function is to return Country by passed Id
     * @param id
     * @return
     */
    public ResultSet getStateById(final int id) throws Exception {
        String Function = "UserCountryDaoImpl:getStateById";

        String query = "SELECT * FROM StateDetails WHERE Id = " + id + ";";

        try {
            return databaseConnection.executeQuery(query);
        } catch (Exception e) {
            String error = "[Error] UserCountryDaoImpl:getStateById Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    /**
     * this function is to return all States
     * @param
     * @return
     */
    public ResultSet getAllState() throws Exception {
            String Function = "UserCountryDaoImpl:getAllState";
            String query = "SELECT * FROM StateDetails;";

            try {
                return databaseConnection.executeQuery(query);
            } catch (Exception e) {
                String error = "[Error] UserCountryDaoImpl:getAllState Exception while executing query [" + query + "]\n" + e;
                System.out.println(error);
                throw new Exception(error);
            }
    }


    /**
     * this function is to return District by Id
     * @param
     * @return
     */
    public ResultSet getDistrictById(final int districtId) throws Exception {
        String Function = "UserCountryDaoImpl:getDistrictById";

        String query = "SELECT * FROM DistrictDetails WHERE Id = " + districtId + ";";

        try {
            return databaseConnection.executeQuery(query);
        } catch (Exception e) {
            String error = "[Error] UserCountryDaoImpl:getDistrictById Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    /**
     * this function is to return All District
     * @param
     * @return
     */
    public ResultSet getAllDistrict() throws Exception {
        String Function = "UserCountryDaoImpl:getAllDistrict";
        String query = "SELECT * FROM DistrictDetails;";

        try {
            return databaseConnection.executeQuery(query);
        } catch (Exception e) {
            String error = "[Error] UserCountryDaoImpl:getAllState Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    /**
     * this function is to return VillageTown by Id
     * @param
     * @return
     */
    public ResultSet getVillageTownById(final int villageTownId) throws Exception {
        String Function = "UserCountryDaoImpl:getVillageTownById";

        String query = "SELECT * FROM VillageTownLocalAreaDetails WHERE Id = " + villageTownId + ";";

        try {
            return databaseConnection.executeQuery(query);
        } catch (Exception e) {
            String error = "[Error] UserCountryDaoImpl:getVillageTownById Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    /**
     * this function is to return All VillageTown
     * @param
     * @return
     */
    public ResultSet getAllVillageTown() throws Exception {
        String Function = "UserCountryDaoImpl:getAllVillageTown";

        String query = "SELECT * FROM VillageTownLocalAreaDetails;";

        try {
            return databaseConnection.executeQuery(query);
        } catch (Exception e) {
            String error = "[Error] UserCountryDaoImpl:getAllVillageTown Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

}
