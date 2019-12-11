package com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest;

import java.sql.ResultSet;

public interface UserReligionDao {

    /**
     * this function is to return the Result set of the query ran on the UserReligionTable
     * @param id
     * @return
     */
    public ResultSet getUserReligionById(final int id) throws Exception;

    /**
     * this function is to return the Result set of the query ran on the UserReligionTable
     *
     * @return
     */
    public ResultSet getUserAllReligions() throws Exception;

}
