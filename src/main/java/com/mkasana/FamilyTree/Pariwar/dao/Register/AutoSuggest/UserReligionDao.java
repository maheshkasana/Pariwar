package com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest;

import com.mkasana.FamilyTree.Pariwar.model.Caste;
import com.mkasana.FamilyTree.Pariwar.model.SubCaste;

import java.sql.ResultSet;
import java.util.List;

public interface UserReligionDao {

    /********************************************
     * All the below Dao are for Religion *
     *******************************************/


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
     * This function is to return the Sub-Caste by Id
     * @param id
     */
    public ResultSet getUserSubCasteById(final int id) throws Exception;


    /**
     * This function is to return the All Sub-Caste
     * @param
     */
    public ResultSet getUserAllSubCaste() throws Exception;


}
