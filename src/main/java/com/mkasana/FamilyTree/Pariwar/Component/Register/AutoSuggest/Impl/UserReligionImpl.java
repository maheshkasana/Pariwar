package com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest.Impl;

import com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest.UserReligion;
import com.mkasana.FamilyTree.Pariwar.dao.DatabaseConnection;
import com.mkasana.FamilyTree.Pariwar.model.Religion;
import com.mkasana.FamilyTree.Pariwar.model.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.sql.ResultSet;
import java.util.List;

@Component
public class UserReligionImpl  implements UserReligion {

    @Autowired
    DatabaseConnection databaseConnection;

    private Religion convertResultSetToReligion(@NotNull ResultSet resultSet) {

        Religion religion = new Religion();
        try {
            religion.setId(resultSet.getInt("Id"));
            religion.setReligionName(resultSet.getString("ReligionName"));
            return religion;
        } catch(Exception e) {
            System.out.println("Does not found religion");
            return new Religion();
        }
    }

    /**
     * This function is to return the Religion by Id
     * @param id
     */
    public Religion getReligionById(int id) {

        String query = "SELECT Id, ReligionName FROM UserReligion WHERE Id = " + id +";";
        try {
            ResultSet resultSet = databaseConnection.executeQuery(query);
            System.out.println("returend Result Set "  + resultSet.toString());
            Religion religion = convertResultSetToReligion(resultSet);
            return religion;
        } catch (Exception e) {
            System.out.println("Failed to Execute Query ["+ query + "]");
            return new Religion(-1," ");
        }
    }

    /**
     * This String is to return the Religion by Name
     * @param name
     * @return
     */
    public Religion getReligionByName(String name) {

        //Todo
        return null;
    }


    /**
     * this function is to return the all the Religions
     * @return
     */
    public List<Religion> getAllReligions() {
        //Todo
        return null;
    }


    /**
     * this is to add new Religion.
     * @param religion
     * @return
     */
    public ReturnStatus addNewReligion(Religion religion) {
        //Todo
        return null;
    }

    /**
     * this is to delete a Religion
     * @param religion
     * @return
     */
    public ReturnStatus deleteReligion(Religion religion) {
        //Todo
        return null;
    }
}
