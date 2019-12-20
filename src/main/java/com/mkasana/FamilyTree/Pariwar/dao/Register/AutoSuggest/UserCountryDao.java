package com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest;

import com.mkasana.FamilyTree.Pariwar.model.*;

import javax.validation.constraints.NotNull;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public interface UserCountryDao {

    /********************************************
     * All the below Dao are for Religion *
     *******************************************/


    /**
     * this function is to return the Result set of the query ran on the UserCountryTable
     * @param id
     * @return
     */
    public ResultSet getUserCountryById(final int id) throws Exception;

    /**
     * this function is to return the all Countries
     * @param
     * @return
     */
    public ResultSet getUserAllCountries() throws Exception;

    /**
     * this is to Create New state in Address
     * @param state
     * @return
     */
    public void createNewState(@NotNull final State state) throws Exception;

    /**
     * this is to Create New district in Address
     * @param district
     * @return
     */
    public void createNewDistrict(final District district) throws Exception;

    /**
     * this is to Create New Teshil in Address
     * @param tehsil
     * @return
     */
    public void createNewTehsil(final Tehsil tehsil) throws Exception;

    /**
     * this is to Create New villageTown in Address
     * @param villageTown
     * @return
     */
    public void createNewVillageTown(final VillageTown villageTown) throws Exception;

    public void insertErrorCodeForTheError(final VillageTown error);
    /**
     * this is to Create New Country in Address
     * @param country
     * @return
     */
    public void createNewCountry(final Country country) throws Exception;


    /**
     * this is to Update Village Town PinCode in Address
     * @param villageTown
     * @return
     */
    public void updateVillageTownPinCode(VillageTown villageTown) throws Exception;

    /**
     * this function is to return Country by passed Id
     * @param id
     * @return
     */
    public ResultSet getStateById(final int id) throws Exception;

    /**
     * this function is to return all States
     * @param
     * @return
     */
    public ResultSet getAllState() throws Exception;


    /**
     * this function is to return District by Id
     * @param
     * @return
     */
    public ResultSet getDistrictById(final int districtId) throws Exception;

    /**
     * this function is to return All District
     * @param
     * @return
     */
    public ResultSet getAllDistrict() throws Exception;

    /**
     * this function is to return All District by state id
     * @param
     * @return
     */
    public ResultSet suggestDistrictByStateId(final int stateId) throws Exception;



    /****************************************************
     *  All the below Controllers are for Teshil        *
     ****************************************************/

    /**
     * this function is to return tehsilId by Id
     * @param tehsilId
     * @return
     */
    public ResultSet getTehsilById(final int tehsilId) throws Exception;

    /**
     * this function is to return All Tehsil;
     * @param
     * @return
     */
    public ResultSet getAllTehsil() throws Exception;

    /**
     * this function is to return All Tehsil by District Id;
     * @param districtId
     * @return
     */
    public ResultSet getAllTehsilByDistrictId(final int districtId) throws Exception;

    /**
     * this function is to return VillageTown by Id
     * @param
     * @return
     */
    public ResultSet getVillageTownById(final int villageTownId) throws Exception;

    /**
     * this function is to return All VillageTown
     * @param
     * @return
     */
    public ResultSet getAllVillageTown() throws Exception;

    /**
     * this function is to return All VillageTown by Tehsil Id
     * @param
     * @return
     */
    public ResultSet getAllVillageTownByTehsilId(final int tehsilId) throws Exception;

}
