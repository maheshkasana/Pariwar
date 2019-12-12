package com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.Impl;


import com.mkasana.FamilyTree.Pariwar.dao.DatabaseConnection;
import com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.UserCountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

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

}
