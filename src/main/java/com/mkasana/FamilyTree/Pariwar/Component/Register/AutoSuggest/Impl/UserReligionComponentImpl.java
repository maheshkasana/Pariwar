package com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest.Impl;

import com.mkasana.FamilyTree.Pariwar.Builder.Register.AutoSuggest.UserReligionBuilder;
import com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest.UserReligionComponent;
import com.mkasana.FamilyTree.Pariwar.model.Caste;
import com.mkasana.FamilyTree.Pariwar.model.Religion;
import com.mkasana.FamilyTree.Pariwar.model.ReturnStatus;
import com.mkasana.FamilyTree.Pariwar.model.SubCaste;
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


    /********************************************
     * All the below Component are for Religion *
     *******************************************/

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



    /*****************************************
     * All the below Component are for caste *
     *****************************************/


    /**
     * This function is to return the Caste by Id
     * @param id
     */
    public Caste getCasteById(final int id) {
        String function = "UserReligionComponentImpl:getCasteById";

        return userReligionBuilder.getCasteById(id);
    }

    /**
     * This String is to return the Caste by Name
     * @param name
     * @return
     */
    public Caste getCasteByName(String name) {
        return null;
    }


    /**
     * this function is to return the all the Caste
     * @return
     */
    public List<Caste> getAllCaste() {
        String function = "UserReligionComponentImpl:getAllCaste";

        return userReligionBuilder.getAllCaste();
    }


    /**
     * this is to add new Caste.
     * @param caste
     * @return
     */
    public ReturnStatus addNewCaste(Caste caste) {
        return null;
    }


    /**
     * this is to delete a Caste
     * @param caste
     * @return
     */
    public ReturnStatus deleteCaste(Caste caste) {
        return null;
    }

    /**
     * this is to return all the caste belongs to the passed religion id.
     * @param religionId
     * @return
     */
    public List<Caste> getAllCasteOfReligion(final int religionId) {
        String function = "UserReligionComponentImpl:getAllCasteOfReligion";

        return userReligionBuilder.getAllCasteOfReligion(religionId);
    }




    /*********************************************
     * All the below Component are for Sub-caste *
     *********************************************/


    /**
     * This function is to return the Sub-Caste by Id
     * @param id
     */
    public SubCaste getSubCasteById(final int id) {
        String function = "UserReligionComponentImpl:getSubCasteById";

        return userReligionBuilder.getSubCasteById(id);
    }

    /**
     * This String is to return the Sub-Caste by Name
     * @param name
     * @return
     */
    public SubCaste getSubCasteByName(String name) {
        return null;
    }


    /**
     * this function is to return the all the Sub-Caste
     * @return
     */
    public List<SubCaste> getAllSubCaste() {
        String function = "UserReligionComponentImpl:getAllSubCaste";

        return userReligionBuilder.getAllSubCaste();
    }


    /**
     * this is to add new Sub-Caste.
     * @param subCaste
     * @return
     */
    public ReturnStatus addNewSubCaste(SubCaste subCaste) {
        return null;
    }

    /**
     * this is to delete a Sub-Caste
     * @param subCaste
     * @return
     */
    public ReturnStatus deleteSubCaste(SubCaste subCaste) {
        return null;
    }

    /**
     * this is to return all the Sub-caste belongs to the passed Caste Id or religion id.
     * @param casteId, religionId

     * @return
     */
    public List<SubCaste> getSuggestAllSubCasteByCasteIdOrReligionId(final int casteId, final int religionId) {

        String function = "[UserReligionComponentImpl:getSuggestAllSubCasteByCasteIdOrReligionId]";

        if(0 >= casteId && 0 >= religionId) {
            System.out.println(function + "Invalid Caste Id [" + casteId + "] & Religion Id ["+ religionId +"] Passed");
            return getAllSubCaste();
        }

        System.out.println(function + "Caste Id [" + casteId + "] & Religion Id ["+ religionId +"] Passed");
        return userReligionBuilder.getSuggestAllSubCasteByCasteIdOrReligionId(casteId, religionId);
    }

}
