package com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest;

import java.sql.ResultSet;

public interface UserReligionDao {

    /**
     * this function is to return the Result set of the query ran on the UserReligionTable
     * @param id
     * @return
     */
    public ResultSet getUserReligionById(int id) throws Exception;
}
