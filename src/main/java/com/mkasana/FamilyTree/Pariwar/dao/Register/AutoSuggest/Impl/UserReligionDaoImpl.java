package com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.Impl;

import com.mkasana.FamilyTree.Pariwar.dao.DatabaseConnection;
import com.mkasana.FamilyTree.Pariwar.dao.Impl.DatabaseConnectionImpl;
import com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.UserReligionDao;
import com.mkasana.FamilyTree.Pariwar.model.Caste;
import com.mkasana.FamilyTree.Pariwar.model.Religion;
import com.mkasana.FamilyTree.Pariwar.model.SubCaste;
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

    /**
     * This function is to Create new Religion
     * @param
     */
    @Override
    public void createNewReligion(final Religion religion) throws Exception {
        String Function = "UserReligionDaoImpl:createNewReligion";

        String query = "INSERT INTO UserReligion(ReligionName, FLag) VALUES \n"
                + "(" + religion.getReligionName() + "," + 1 + ");";
        try {
            databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserCountryDaoImpl:createNewReligion Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }


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
     * this function is to create new Caste
     * @param caste
     * @return
     */
    @Override
    public void createNewCaste(final Caste caste) throws Exception {
        String Function = "UserReligionDaoImpl:createNewCaste";

        String query = "INSERT INTO UserCaste(UserCasteName,UserReligionId, FLag) VALUES \n"
                + "(" + caste.getUserCasteName() + "," + caste.getUserReligionId() + ", " + 1 + ");";
        try {
            databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserCountryDaoImpl:createNewCaste Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }



    /**
     * this function is to return the Result set of the query ran on the UserCaste Table
     * @param id
     * @return
     */

    @Override
    public ResultSet getUserCasteById(final int id) throws Exception {

        String function = "UserReligionDaoImpl:getUserCasteById";

        String query = "SELECT UserCaste.Id, UserCaste.UserCasteName, UserCaste.UserReligionId, UR.ReligionName\n" +
                        "FROM UserCaste\n" +
                        "JOIN UserReligion AS UR ON UR.Id = UserCaste.UserReligionId\n" +
                        "WHERE UserCaste.Id = " + id + ";";
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

        String query = "SELECT UserCaste.Id, UserCaste.UserCasteName, UserCaste.UserReligionId, UR.ReligionName\n" +
                        "FROM UserCaste\n" +
                        "JOIN UserReligion AS UR ON UR.Id = UserCaste.UserReligionId;";

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

        String query = "SELECT UserCaste.Id, UserCaste.UserCasteName, UserCaste.UserReligionId, UR.ReligionName\n" +
                "FROM UserCaste\n" +
                "JOIN UserReligion AS UR ON UR.Id = UserCaste.UserReligionId AND UR.Id = "+ religionId +";";

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
     * This function is to Create new SubCaste
     * @param subCaste
     */
    public void createNewSubCaste(final SubCaste subCaste) throws Exception {
        String Function = "UserReligionDaoImpl:createNewSubCaste";

        String query = "INSERT INTO UserSubCaste(UserSubcasteName, UserCasteId, Flag) VALUES \n"
                + "(" + subCaste.getUserSubCasteName() + "," + subCaste.getUserCasteId() + ", " + 1 + ");";
        try {
            databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserCountryDaoImpl:createNewSubCaste Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    /**
     * This function is to return the Sub-Caste by Id
     * @param id
     */
    public ResultSet getUserSubCasteById(final int id) throws Exception {
        String function = "UserReligionDaoImpl:getUserSubCasteById";
        String query = "SELECT UserSubCaste.Id, UserSubCaste.UserSubcasteName, UserSubCaste.UserCasteId, UC.UserReligionId, UC.UserCasteName, UR.ReligionName\n" +
                        "FROM UserSubCaste\n" +
                        "JOIN UserCaste AS UC ON UC.ID = UserSubCaste.UserCasteId\n" +
                        "JOIN UserReligion AS UR ON UR.Id = UC.UserReligionId\n" +
                        "WHERE UserSubCaste.Id = " + id + ";";

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
        String query = "SELECT UserSubCaste.Id, UserSubCaste.UserSubcasteName, UserSubCaste.UserCasteId, UC.UserReligionId, UC.UserCasteName, UR.ReligionName\n" +
                       "FROM UserSubCaste\n" +
                       "JOIN UserCaste AS UC ON UC.ID = UserSubCaste.UserCasteId\n" +
                       "JOIN UserReligion AS UR ON UR.Id = UC.UserReligionId;";
        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserReligionDaoImpl:getUserAllSubCaste Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    /**
     * this is to return all the Sub-caste belongs to the passed Caste Id or religion id.
     * @param casteId, religionId

     * @return
     */
    public ResultSet getAllSubCasteByCasteIdOrReligionId(final int casteId, final int religionId) throws Exception {

        String function = "UserReligionDaoImpl:getAllSubCasteByCasteIdOrReligionId";
        String query = "SELECT UserSubCaste.Id, UserSubCaste.UserSubcasteName, UserSubCaste.UserCasteId, UC.UserReligionId, UC.UserCasteName, UR.ReligionName\n" +
                "FROM UserSubCaste\n";

        String caste = "JOIN UserCaste AS UC ON UC.ID = UserSubCaste.UserCasteId ";
        if(0 < casteId)
            caste += " AND UC.Id = " + casteId + "\n";
        else
            caste += "\n";

        String religion = "JOIN UserReligion AS UR ON UR.Id = UC.UserReligionId ";
        if(0 < religionId)
            religion += "AND UR.Id = " + religionId;

        query += caste + religion + ";";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserReligionDaoImpl:getAllSubCasteByCasteIdOrReligionId Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }




}
