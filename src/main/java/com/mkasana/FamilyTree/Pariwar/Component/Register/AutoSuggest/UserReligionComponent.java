package com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest;

import com.mkasana.FamilyTree.Pariwar.model.Religion;
import com.mkasana.FamilyTree.Pariwar.model.ReturnStatus;

import java.util.List;


public interface UserReligionComponent {
    /**
     * This function is to return the Religion by Id
     * @param id
     */
    public Religion getReligionById(final int id);

    /**
     * This String is to return the Religion by Name
     * @param name
     * @return
     */
    public Religion getReligionByName(String name);


    /**
     * this function is to return the all the Religions
     * @return
     */
    public List<Religion> getAllReligions();


    /**
     * this is to add new Religion.
     * @param religion
     * @return
     */
    public ReturnStatus addNewReligion(Religion religion);

    /**
     * this is to delete a Religion
     * @param religion
     * @return
     */
    public ReturnStatus deleteReligion(Religion religion);

}
