package com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest;

import com.mkasana.FamilyTree.Pariwar.model.Caste;
import com.mkasana.FamilyTree.Pariwar.model.Religion;
import com.mkasana.FamilyTree.Pariwar.model.ReturnStatus;
import com.mkasana.FamilyTree.Pariwar.model.SubCaste;

import java.util.List;


public interface UserReligionComponent {

    /********************************************
     * All the below Component are for Religion *
     ********************************************/


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





    /*****************************************
     * All the below Component are for caste *
     *****************************************/


    /**
     * This function is to return the Caste by Id
     * @param id
     */
    public Caste getCasteById(final int id);

    /**
     * This String is to return the Caste by Name
     * @param name
     * @return
     */
    public Caste getCasteByName(String name);


    /**
     * this function is to return the all the Caste
     * @return
     */
    public List<Caste> getAllCaste();


    /**
     * this is to add new Caste.
     * @param caste
     * @return
     */
    public ReturnStatus addNewCaste(Caste caste);

    /**
     * this is to delete a Caste
     * @param caste
     * @return
     */
    public ReturnStatus deleteCaste(Caste caste);


    /**
     * this is to return all the caste belongs to the passed religion id.
     * @param religionId

     * @return
     */
    public List<Caste> getAllCasteOfReligion(final int religionId);




    /*********************************************
     * All the below Component are for Sub-caste *
     *********************************************/


    /**
     * This function is to return the Sub-Caste by Id
     * @param id
     */
    public SubCaste getSubCasteById(final int id);

    /**
     * This String is to return the Sub-Caste by Name
     * @param name
     * @return
     */
    public SubCaste getSubCasteByName(String name);


    /**
     * this function is to return the all the Sub-Caste
     * @return
     */
    public List<SubCaste> getAllSubCaste();


    /**
     * this is to add new Sub-Caste.
     * @param subCaste
     * @return
     */
    public ReturnStatus addNewSubCaste(SubCaste subCaste);

    /**
     * this is to delete a Sub-Caste
     * @param subCaste
     * @return
     */
    public ReturnStatus deleteSubCaste(SubCaste subCaste);


    /**
     * this is to return all the Sub-caste belongs to the passed religion id.
     * @param religionId

     * @return
     */
    //public List<Caste> getAllCasteOfReligion(final int religionId);


}
