package com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest;

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
}
