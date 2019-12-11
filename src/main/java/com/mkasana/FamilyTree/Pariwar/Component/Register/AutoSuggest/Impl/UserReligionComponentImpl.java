package com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest.Impl;

import com.mkasana.FamilyTree.Pariwar.Builder.Register.AutoSuggest.UserReligionBuilder;
import com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest.UserReligionComponent;
import com.mkasana.FamilyTree.Pariwar.model.Religion;
import com.mkasana.FamilyTree.Pariwar.model.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.sql.ResultSet;
import java.util.List;

@Component
@Configurable
public class UserReligionComponentImpl  implements UserReligionComponent {

    @Autowired
    public UserReligionBuilder userReligionBuilder;

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
    @Override
    public Religion getReligionById(final int id) {

        String function = "UserReligionComponentImpl:getReligionById";

        return userReligionBuilder.getReligionById(id);
    }


    /**
     * this function is to return the all the Religions
     * @return
     */
    @Override
    public List<Religion> getAllReligions() {
        String function = "UserReligionComponentImpl:getAllReligions";

        return userReligionBuilder.getAllReligions();
    }


    /**
     * This String is to return the Religion by Name
     * @param name
     * @return
     */
    @Override
    public Religion getReligionByName(String name) {

        //Todo
        return null;
    }


    /**
     * this is to add new Religion.
     * @param religion
     * @return
     */
    @Override
    public ReturnStatus addNewReligion(Religion religion) {
        //Todo
        return null;
    }

    /**
     * this is to delete a Religion
     * @param religion
     * @return
     */
    @Override
    public ReturnStatus deleteReligion(Religion religion) {
        //Todo
        return null;
    }
}
