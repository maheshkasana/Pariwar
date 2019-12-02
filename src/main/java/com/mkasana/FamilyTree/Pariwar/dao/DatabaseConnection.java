package com.mkasana.FamilyTree.Pariwar.dao;

import java.sql.ResultSet;

public interface DatabaseConnection {

    public boolean close() throws Exception;

    public boolean commit() throws Exception;

    public boolean getAutoCommit() throws Exception;

    public void changeAutoCommit(boolean autoCommit) throws Exception;

    public boolean rollback() throws Exception;

    public ResultSet executeQuery(String query) throws Exception;

    public int executeUpdate(String query) throws Exception;

    public String executeScript(String path) throws Exception;
}
