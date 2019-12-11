package com.mkasana.FamilyTree.Pariwar.Builder.Register.AutoSuggest;

import com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.Impl.UserReligionDaoImpl;
import com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.UserReligionDao;
import com.mkasana.FamilyTree.Pariwar.model.Religion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;

@Configurable
@Component
public class UserReligionBuilder {

    @Autowired
    public UserReligionDao userReligionDao;


    public Religion getReligionById(int id) {
        String function = "UserReligionBuilder:getReligionById";

        try {
            ResultSet resultSet = userReligionDao.getUserReligionById(id);
            //Todo Convert the result set to the religion
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
