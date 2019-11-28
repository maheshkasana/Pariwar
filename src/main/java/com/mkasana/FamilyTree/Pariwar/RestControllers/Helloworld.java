package com.mkasana.FamilyTree.Pariwar.RestControllers;

import com.mkasana.FamilyTree.Pariwar.dao.Impl.DatabaseConnectionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {

    @Autowired
    DatabaseConnectionImpl databaseConnection;

    @RequestMapping("/HelloWorld")
    public String index() {

        try {

            /*
            //DatabaseConnectionImpl databaseConnection =  new DatabaseConnectionImpl();
            ResultSet result = databaseConnection.executeQuery("select  * from testKasana");
            while (result.next()) {
                System.out.println(result.getString("id")+", "+result.getString("name")+", "+result.getString("lastname")+"\n");
            }
            */
            String result = databaseConnection.executeScript("test.sql");
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
