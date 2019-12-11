package com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.Impl;

import com.mkasana.FamilyTree.Pariwar.dao.DatabaseConnection;
import com.mkasana.FamilyTree.Pariwar.dao.Impl.DatabaseConnectionImpl;
import com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.UserReligionDao;
import com.mkasana.FamilyTree.Pariwar.model.Caste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;

@Component
@Configurable
public class UserReligionDaoImpl implements UserReligionDao {

    @Autowired
    public DatabaseConnection databaseConnection;

    /*
    public UserReligionDaoImpl() {
        try {
            databaseConnection = new DatabaseConnectionImpl();
        } catch(Exception e) {
            System.out.println(e);
            databaseConnection = null;
        }

    }
    */





    /********************************************
     * All the below Dao are for Religion *
     *******************************************/


    @Override
    public ResultSet getUserReligionById(final int id) throws Exception {

        String function = "UserReligionDaoImpl:getUserReligionById";

        String query = "SELECT * FROM UserReligion WHERE Id = " + id + ";";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserReligionDaoImpl:getUserReligionById Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    @Override
    public ResultSet getUserAllReligions() throws Exception {

        String function = "UserReligionDaoImpl:getUserAllReligions";

        String query = "SELECT * FROM UserReligion;";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserReligionDaoImpl:getUserAllReligions Exception while executing query [" + query + "]\n" +e;
            System.out.println(error);
            throw new Exception(error);
        }
    }







    /********************************************
     * All the below Dao are for Caste    *
     *******************************************/


    /**
     * this function is to return the Result set of the query ran on the UserCaste Table
     * @param id
     * @return
     */

    @Override
    public ResultSet getUserCasteById(final int id) throws Exception {

        String function = "UserReligionDaoImpl:getUserCasteById";

        String query = "SELECT * FROM UserCaste WHERE Id = " + id + ";";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserReligionDaoImpl:getUserCasteById Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }


    /**
     * this function is to return the Result set of the query ran on the UserCaste Table
     * @param
     * @return
     */

    @Override
    public ResultSet getUserAllCaste() throws Exception {

        String function = "UserReligionDaoImpl:getUserAllCaste";

        String query = "SELECT * FROM UserCaste;";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserReligionDaoImpl:getUserAllCaste Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }


    /**
     * this is to return all the caste belongs to the passed religion id.
     * @param religionId
     * @return
     */
    public ResultSet getUserAllCasteOfReligion(final int religionId) throws Exception {
        String function = "UserReligionDaoImpl:getUserAllCasteOfReligion";

        String query = "SELECT * FROM UserCaste WHERE UserReligionId = " + religionId + ";";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserReligionDaoImpl:getUserAllCasteOfReligion Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }






    /*********************************************
     * All the below Builder are for Sub-caste   *
     *********************************************/



    /**
     * This function is to return the Sub-Caste by Id
     * @param id
     */
    public ResultSet getUserSubCasteById(final int id) throws Exception {
        String function = "UserReligionDaoImpl:getUserSubCasteById";
        String query = "SELECT * FROM UserSubCaste WHERE  Id = " + id + ";";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserReligionDaoImpl:getUserSubCasteById Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    /**
     * This function is to return the All Sub-Caste
     * @param
     */
    public ResultSet getUserAllSubCaste() throws Exception {
        String function = "UserReligionDaoImpl:getUserAllSubCaste";
        String query = "SELECT * FROM UserSubCaste;";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserReligionDaoImpl:getUserAllSubCaste Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

}
