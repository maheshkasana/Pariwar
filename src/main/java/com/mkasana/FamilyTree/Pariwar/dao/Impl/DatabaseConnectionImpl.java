package com.mkasana.FamilyTree.Pariwar.dao.Impl;

import com.mkasana.FamilyTree.Pariwar.dao.DatabaseConnection;
import com.mkasana.FamilyTree.Pariwar.utility.PariwarException;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.sql.*;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;


@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DatabaseConnectionImpl implements DatabaseConnection {

    //private static DatabaseConnectionImpl databaseConnection = null;
    private String mysqlUrl;
    private Connection connection;

    /**
     * this is Constructor if dor initilizing all the required values
     * @throws Exception
     */
    public DatabaseConnectionImpl() throws PariwarException
    {
        mysqlUrl = "jdbc:mysql://localhost/Pariwar";
        try {
            connection = DriverManager.getConnection(mysqlUrl, "pariwar", "pariwar");
            connection.setAutoCommit(false);
        }
        catch(Exception e)
        {
            connection = null;
            throw(new PariwarException("DatabaseConnectionImpl:DatabaseConnectionImpl() Failed to get connection object to the database"));
        }
    }

    /**
     * This function is to close the Connection to database
     * @return
     * @throws Exception
     */
    public boolean close() throws Exception
    {
        if(connection!=null)
        {
            connection.close();
            return true;
        }
       else
           throw  new PariwarException("DatabaseConnectionImpl:close() : Connection is broken or Connection is null, failed to close connection");
    }

    /**
     * this will return the status in any case
     * @return
     * @throws Exception
     */
    public boolean isClosed() throws Exception
    {
        if(connection!=null)
            return connection.isClosed();
        else
            throw  new PariwarException("DatabaseConnectionImpl:isClose() : Connection is broken or Connection is null, failed to get connection status");
    }

    /**
     * to get the AutoCommit state
     * @return
     * @throws Exception
     */
    public boolean getAutoCommit() throws Exception
    {
        if(connection!=null)
            return connection.getAutoCommit();
        else
            throw  new PariwarException("DatabaseConnectionImpl:getAutoCommit() : Connection is broken or Connection is null, failed to AutoCommit status");
    }

    /**
     * this is to change the AutoCommit (true : autoCommit happens, False : need to Commit else will get rollback)
     * @param autoCommit
     * @throws Exception
     */
    public void changeAutoCommit(boolean autoCommit) throws Exception
    {
        if(connection!=null)
        {
            connection.setAutoCommit(autoCommit);
        }
        else
            throw  new PariwarException("DatabaseConnectionImpl:changeAutoCommit() : Connection is broken or Connection is null, failed to change AutoCommit status");
    }

    /**
     * this is to Commit the changes
     * @return
     * @throws Exception
     */
    public boolean commit() throws Exception
    {
        if(connection!=null)
        {
            connection.commit();
            return true;
        }
        else
            throw  new PariwarException("DatabaseConnectionImpl:commit() : Connection is broken or Connection is null, failed to Commit changes");
    }


    /**
     * this function is to rollback the tranction after last commit.
     * @return
     * @throws Exception
     */
    public boolean rollback() throws Exception
    {
        if(connection!=null)
        {
            connection.rollback();
            return true;
        }
        else
            throw  new PariwarException("DatabaseConnectionImpl:rollback() : Connection is broken or Connection is null, failed to rollback changes");
    }

    /**
     * This function is to execute a sql Query
     * @param query
     * @return
     * @throws Exception
     */
    public ResultSet executeQuery(String query) throws Exception
    {
        if(connection!=null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        }
        else
            throw  new PariwarException("DatabaseConnectionImpl:executeQuery() : Connection is broken or Connection is null, failed to execute Query");
    }

    /**
     *
     * @param query
     * @return
     * @throws Exception
     */
    public int executeUpdate(String query) throws Exception
    {
        if(connection!=null) {
            Statement statement = connection.createStatement();
            int returned = statement.executeUpdate(query);
            return returned;
        }
        else
            throw  new PariwarException("DatabaseConnectionImpl:executeUpdate() : Connection is broken or Connection is null, failed to execute Update");
    }


    /**
     * this function is to run the Stored Procedure with input as XML and Output as XML
     * @param storedProcedureName
     * @param inputXML
     * @return Returns the SPs Output XML
     * @throws SQLException
     */
    public String callStoredProcedure(String storedProcedureName, String inputXML) throws Exception {

        if (connection != null) {

            CallableStatement statement = connection.prepareCall("{call " + storedProcedureName + "(?,?)}");
            statement.setString(1, inputXML);
            statement.registerOutParameter(2, Types.VARCHAR);
            statement.execute();
            return statement.getString(2);
        }
        else
            throw  new PariwarException("DatabaseConnectionImpl:callStoredProcedure() : Connection is broken or Connection is null, failed to execute callStoredProcedure");
    }


    /**
     * This functions is to run Sql Script file. (Stored Procedure)
     * @param filename
     * @return
     * @throws Exception
     */
    public String executeScript(String filename) throws Exception
    {

        String filePath = "static/sqlScripts/"+filename;
        ClassLoader classLoader = new DatabaseConnectionImpl().getClass().getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());

        if(file.exists()) {
            String content = new String(Files.readAllBytes(file.toPath()));
            System.out.println(content);
            /*
            ScriptRunner sr = new ScriptRunner(connection);
            //Creating a reader object
            Reader reader = new BufferedReader(new FileReader(path));
            //Running the script
            System.out.printf("\nFile read as per Path : %s", ((BufferedReader) reader).readLine());
            sr.runScript(content);
            */
        }
        else {
            throw new Exception("File ["+filePath+"] does not exists.");
        }

        //Read File Content

        /*
        ScriptRunner sr = new ScriptRunner(connection);
        //Creating a reader object
        Reader reader = new BufferedReader(new FileReader(path));
        //Running the script
        System.out.printf("\nFile read as per Path : %s", ((BufferedReader) reader).readLine());
        //sr.runScript("select * from testKasana");
        */
        return "";

    }

}
