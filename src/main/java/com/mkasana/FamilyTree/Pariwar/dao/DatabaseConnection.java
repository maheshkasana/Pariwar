package com.mkasana.FamilyTree.Pariwar.dao;

import java.sql.ResultSet;

public interface DatabaseConnection {

    /**
     * To Execute Query on database
     * @param query
     * @return
     */
    public ResultSet executeQuery(String query) throws Exception;

    public String executeScript(String path) throws Exception;
}
