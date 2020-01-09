package com.mkasana.FamilyTree.Pariwar.dao.commonAPIs.Impl;

import com.mkasana.FamilyTree.Pariwar.dao.DatabaseConnection;
import com.mkasana.FamilyTree.Pariwar.dao.commonAPIs.CommonAPIsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.time.Instant;


@Component
@Configurable
public class CommonAPIsDAOImpl implements CommonAPIsDAO {

    @Autowired
    private DatabaseConnection databaseConnection;

    public ResultSet getBasicUserDetailsByUsername(final String username) throws Exception {
        String Function = "CommonAPIsDAOImpl:getBasicUserDetailsByUsername";

        String query = "SELECT * FROM userinfo WHERE Username = '"+username+"';";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] "+Function+" Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public void setSessionDetails(final int UserId,final String username, final String GUID) throws Exception {
        String Function = "CommonAPIsDAOImpl:setSessionDetails";
        long ut1 = Instant.now().getEpochSecond();

        String query = "INSERT INTO UserSessionManagement(UserId, Username, Token, Created, Updated, DeleteIt, Flag) VALUES \n"
                + "(" + UserId + ",'" + username + "','" + GUID + "'," + ut1 + "," + ut1 + "," + 0 + "," + 0 + ");";
        try {
            databaseConnection.executeUpdate(query);
            databaseConnection.commit();
        } catch(Exception e) {
            String error = "[Error] CommonAPIsDAOImpl:setSessionDetails Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public void updateSessionDetailsLastUse(final String GUID) throws Exception {
        String Function = "CommonAPIsDAOImpl:updateSessionDetailsLastUse";
        long ut1 = Instant.now().getEpochSecond();

        String query = "UPDATE UserSessionManagement SET Updated =" + ut1 + ", Flag = Flag + 1 WHERE Token = '"+ GUID + "';";
        try {
            databaseConnection.executeUpdate(query);
            databaseConnection.commit();
        } catch(Exception e) {
            String error = "[Error] CommonAPIsDAOImpl:updateSessionDetailsLastUse Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public void deleteOldSessionDetails() throws Exception {
        String Function = "CommonAPIsDAOImpl:deleteOldSessionDetails";
        long ut1 = Instant.now().getEpochSecond();

        String query = "DELETE FROM UserSessionManagement WHERE " + ut1 + " - Updated > 600 OR " + ut1 + " - Created > 24*60*60 OR Flag > 100";
        try {
            databaseConnection.executeUpdate(query);
            databaseConnection.commit();
        } catch(Exception e) {
            String error = "[Error] CommonAPIsDAOImpl:deleteOldSessionDetails Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public ResultSet getSessionDetailsByToken(final String GUID) throws Exception {
        String Function = "CommonAPIsDAOImpl:getSessionDetailsByToken";

        String query = "SELECT * FROM UserSessionManagement WHERE Token = '"+GUID+"';";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] CommonAPIsDAOImpl:getSessionDetailsByToken Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public ResultSet getUserInfoDetailsByUserId(final int userId) throws Exception {
        String Function = "CommonAPIsDAOImpl:getUserInfoDetailsByUserId";

        String query = "SELECT * FROM userinfo WHERE Id = "+userId+";";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] "+Function+" Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public ResultSet getRegistrationAddressDetailsByAddressDetailsId(final int addressDetailId) throws Exception {
        String Function = "CommonAPIsDAOImpl:getRegistrationAddressDetailsByAddressDetailsId";

        String query = "SELECT * FROM UserAddressDetails WHERE Id = "+addressDetailId+";";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] "+Function+" Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public ResultSet getRegistrationReligionDetailsByReligiousDetailId(final int ReligiousDetailsId) throws Exception {
        String Function = "CommonAPIsDAOImpl:getRegistrationReligionDetailsByReligiousDetailId";

        String query = "SELECT * FROM UserReligionMapDetails WHERE Id = "+ReligiousDetailsId+";";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] "+Function+" Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }
}
