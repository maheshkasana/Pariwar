package com.mkasana.FamilyTree.Pariwar.RestController;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.io.FileNotFoundException;
import java.sql.Statement;
import java.sql.ResultSet;
import org.apache.ibatis.jdbc.ScriptRunner;

@RestController
public class Helloworld {


    @RequestMapping("/HelloWorld")
    public String index() {

        try {
            //Registering the Driver
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //Getting the connection
            String mysqlUrl = "jdbc:mysql://localhost/Pariwar";
            Connection con = DriverManager.getConnection(mysqlUrl, "pariwar", "pariwar");
            System.out.println("Connection established......");

            Statement stmt = con.createStatement();
            ResultSet res=stmt.executeQuery("Select * from testKasana");
            while (res.next()) {
                System.out.println(res.getString("name"));
            }
            con.close();
            //Initialize the script runner
            //ScriptRunner sr = new ScriptRunner(con);
            //Creating a reader object
            //Reader reader = new BufferedReader(new FileReader("E:\\sampleScript.sql"));
            //Running the script
            //sr.runScript("select * from testKasana");
        }
        catch(Exception e) {
            System.out.println("Fat gya bhai try");
        }
        return "Yo Bro Kasana, Tujh se na ho payega";
    }

}
