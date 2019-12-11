package com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.Impl;

import com.mkasana.FamilyTree.Pariwar.dao.DatabaseConnection;
import com.mkasana.FamilyTree.Pariwar.dao.Impl.DatabaseConnectionImpl;
import com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.UserReligionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;

@Component
@Configurable
public class UserReligionDaoImpl implements UserReligionDao {

    @Autowired
    public DatabaseConnection databaseConnection;

    /*
    public UserReligionDaoImpl() {
        try {
            databaseConnection = new DatabaseConnectionImpl();
        } catch(Exception e) {
            System.out.println(e);
            databaseConnection = null;
        }

    }
    */

    @Override
    public ResultSet getUserReligionById(int id) throws Exception {

        String function = "UserReligionDaoImpl:getUserReligionById";

        String query = "SELECT * FROM UserReligion WHERE Id = " + id + ";";

        try {
            databaseConnection.executeQuery(query);
        } catch(Exception e) {
            System.out.println(e);
            String error = "[Error] UserReligionDaoImpl:getUserReligionById Exception while executing query ["+query+"]";
            System.out.println(error);
            throw new Exception(error);
        }
        return null;
    }
}
