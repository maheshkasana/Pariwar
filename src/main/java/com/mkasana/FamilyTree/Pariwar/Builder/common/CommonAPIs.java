package com.mkasana.FamilyTree.Pariwar.Builder.common;


import com.mkasana.FamilyTree.Pariwar.dao.commonAPIs.CommonAPIsDAO;
import com.mkasana.FamilyTree.Pariwar.model.userRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;

@Configurable
@Component
public class CommonAPIs {

    @Autowired
    private CommonAPIsDAO userCommonAPIsDAO;

    public userRegistrationRequest getBasicUserDetailsByUsername(final String username) {
        try {
            ResultSet resultSet = userCommonAPIsDAO.getBasicUserDetailsByUsername(username);
            if(resultSet.next()) {
               return ConvertResultSetToObject(resultSet);
            }
        } catch(Exception e) {
            System.out.println(e);
            return null;
        }
        return null;
    }

    private userRegistrationRequest ConvertResultSetToObject(ResultSet resultSet) {
        userRegistrationRequest details = new userRegistrationRequest();
        try {
            details.setUsername(resultSet.getString("Username"));
            details.setFirstname(resultSet.getString("FirstName"));
            details.setPassword(resultSet.getString("Passphrase"));
            details.setDateofbirth(resultSet.getString("DateOfBirth"));
            details.setUserId(resultSet.getInt("Id"));
            return details;
        } catch(Exception e) {
            return null;
        }
    }


    public boolean setSessionDetails(final int UserId,final String username, final String GUID) {
        try {
            userCommonAPIsDAO.setSessionDetails(UserId, username, GUID);
            return true;
        } catch (Exception e) {
            System.out.println("Failed to add the session details for the user");
            return false;
        }
    }
}
