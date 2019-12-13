package com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest;

import com.mkasana.FamilyTree.Pariwar.model.Caste;
import com.mkasana.FamilyTree.Pariwar.model.Religion;
import com.mkasana.FamilyTree.Pariwar.model.ReturnStatus;
import com.mkasana.FamilyTree.Pariwar.model.SubCaste;

import java.sql.ResultSet;
import java.util.List;

public interface UserReligionDao {

    /********************************************
     * All the below Dao are for Religion *
     *******************************************/

    /**
     * This function is to Create new Religion
     * @param
     */
    public void createNewReligion(final Religion religion) throws Exception;

    /**
     * this function is to return the Result set of the query ran on the UserReligionTable
     * @param id
     * @return
     */
    public ResultSet getUserReligionById(final int id) throws Exception;

    /**
     * this function is to return the Result set of the query ran on the UserReligion Table
     *
     * @return
     */
    public ResultSet getUserAllReligions() throws Exception;






    /********************************************
     * All the below Dao are for Caste *
     *******************************************/

    /**
     * this function is to create new Caste
     * @param caste
     * @return
     */
    public void createNewCaste(final Caste caste) throws Exception;


    /**
     * this function is to return the Result set of the query ran on the UserCaste Table
     * @param id
     * @return
     */
    public ResultSet getUserCasteById(final int id) throws Exception;

    /**
     * this function is to return the Result set of the query ran on the UserCaste Table
     * @param
     * @return
     */
    public ResultSet getUserAllCaste() throws Exception;


    /**
     * this is to return all the caste belongs to the passed religion id.
     * @param religionId
     * @return
     */
    public ResultSet getUserAllCasteOfReligion(final int religionId)  throws Exception;





    /*********************************************
     * All the below Builder are for Sub-caste *
     *********************************************/

    /**
     * This function is to Create new SubCaste
     * @param subCaste
     */
    public void createNewSubCaste(final SubCaste subCaste) throws Exception;

    /**
     * This function is to return the Sub-Caste by Id
     * @param id
     */
    public ResultSet getUserSubCasteById(final int id) throws Exception;


    /**
     * This function is to return the All Sub-Caste
     * @param
     */
    public ResultSet getUserAllSubCaste() throws Exception;


    /**
     * this is to return all the Sub-caste belongs to the passed Caste Id or religion id.
     * @param casteId, religionId

     * @return
     */
    public ResultSet getAllSubCasteByCasteIdOrReligionId(final int casteId, final int religionId) throws Exception ;


    }
