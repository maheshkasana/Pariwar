package com.mkasana.FamilyTree.Pariwar.dao.Impl;

import com.mkasana.FamilyTree.Pariwar.dao.DatabaseConnection;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


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
    public DatabaseConnectionImpl() throws Exception
    {
        mysqlUrl = "jdbc:mysql://localhost/Pariwar";
        try {
            connection = DriverManager.getConnection(mysqlUrl, "pariwar", "pariwar");
            connection.setAutoCommit(false);
        }
        catch(Exception e)
        {
            connection = null;
            throw(new Exception("DatabaseConnectionImpl:DatabaseConnectionImpl() Failed to get connection object to the database"));
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
        return false;
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
        return false;
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
        return false;
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
        return false;
    }

    /**
     * This function is to execute a sql Query
     * @param query
     * @return
     * @throws Exception
     */
    public ResultSet executeQuery(String query) throws Exception
    {
        Statement statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery(query);
        return resultSet;
    }

    /**
     *
     * @param query
     * @return
     * @throws Exception
     */
    public int executeUpdate(String query) throws Exception
    {
        Statement statement = connection.createStatement();
        int returned =statement.executeUpdate(query);
        return returned;
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
