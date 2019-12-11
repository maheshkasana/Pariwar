package com.mkasana.FamilyTree.Pariwar.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseConnection {

    public boolean close() throws Exception;

    boolean isClosed() throws Exception;

    public boolean commit() throws Exception;

    public boolean getAutoCommit() throws Exception;

    public void changeAutoCommit(boolean autoCommit) throws Exception;

    public boolean rollback() throws Exception;

    public ResultSet executeQuery(final String query) throws Exception;

    public int executeUpdate(String query) throws Exception;

    public String executeScript(String path) throws Exception;

    public String callStoredProcedure(String storedProcedureName, String inputXML) throws Exception;
}
