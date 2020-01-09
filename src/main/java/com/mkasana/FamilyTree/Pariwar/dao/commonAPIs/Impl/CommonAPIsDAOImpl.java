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
}
