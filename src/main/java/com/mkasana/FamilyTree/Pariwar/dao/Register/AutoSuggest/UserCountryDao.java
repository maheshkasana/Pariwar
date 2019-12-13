package com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest;

import com.mkasana.FamilyTree.Pariwar.model.*;

import javax.validation.constraints.NotNull;
import java.sql.ResultSet;

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
     * this is to Create New villageTown in Address
     * @param villageTown
     * @return
     */
    public void createNewVillageTown(final VillageTown villageTown) throws Exception;

    /**
     * this is to Create New Country in Address
     * @param country
     * @return
     */
    public void createNewCountry(final Country country) throws Exception;
}
