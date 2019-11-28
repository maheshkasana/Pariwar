package com.mkasana.FamilyTree.Pariwar.dao.Impl;

import com.mkasana.FamilyTree.Pariwar.dao.DatabaseConnection;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
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

    public DatabaseConnectionImpl() throws Exception
    {
        mysqlUrl = "jdbc:mysql://localhost/Pariwar";
        try {
            connection = DriverManager.getConnection(mysqlUrl, "pariwar", "pariwar");
        }
        catch(Exception e)
        {
            connection = null;
            throw(new Exception("DatabaseConnectionImpl:DatabaseConnectionImpl() Failed to get connection object to the database"));
        }
    }
    /*
    private DatabaseConnectionImpl() throws Exception
    {
        mysqlUrl = "jdbc:mysql://localhost/Pariwar";
        try {
            connection = DriverManager.getConnection(mysqlUrl, "pariwar", "pariwar");
        }
        catch(Exception e)
        {
            connection = null;
            throw(new Exception("DatabaseConnectionImpl:DatabaseConnectionImpl() Failed to get connection object to the database"));
        }
    }

    public static DatabaseConnectionImpl getDatabaseConnection() throws Exception
    {
        if(databaseConnection==null)
            databaseConnection = new DatabaseConnectionImpl();
        return databaseConnection;
    }

    public static DatabaseConnectionImpl getNewDatabaseConnection() throws Exception
    {
            return databaseConnection = new DatabaseConnectionImpl();
    }

    public void CloseDatabaseConnection() throws Exception
    {
        connection.close();
    }
    */

    public ResultSet executeQuery(String query) throws Exception
    {
        Statement statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery(query);
        return resultSet;
    }

    public String executeScript(String path) throws Exception
    {
        ScriptRunner sr = new ScriptRunner(connection);
        //Creating a reader object
        Reader reader = new BufferedReader(new FileReader(path));
        //Running the script
        System.out.printf("\nFile read as per Path : %s", ((BufferedReader) reader).readLine());
        //sr.runScript("select * from testKasana");
        return "";
    }

}
