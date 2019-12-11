package com.mkasana.FamilyTree.Pariwar.Builder.Register.AutoSuggest;

import com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.Impl.UserReligionDaoImpl;
import com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.UserReligionDao;
import com.mkasana.FamilyTree.Pariwar.model.Religion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Configurable
@Component
public class UserReligionBuilder {

    @Autowired
    public UserReligionDao userReligionDao;


    /**
     * This function is to return Religion for Religion Id
     * @param id
     * @return
     */
    public Religion getReligionById(final int id) {
        final String function = "UserReligionBuilder:getReligionById";

        ResultSet resultSet;
        Religion religion = new Religion();
        try {
            resultSet = userReligionDao.getUserReligionById(id);
            if(resultSet.next()) {
                religion.setId(resultSet.getInt("Id"));
                religion.setReligionName(resultSet.getString("ReligionName"));
            }
            //Todo Convert the result set to the religion
        } catch(Exception e) {
            System.out.println(e);
        }
        return religion;
    }


    /**
     * this function is for returning All the available religions
     * @return
     */
    public List<Religion> getAllReligions() {
        final String function = "UserReligionBuilder:getAllReligions";

        ResultSet resultSet;
        List<Religion> religions = new ArrayList<>();

        try {
            resultSet = userReligionDao.getUserAllReligions();
            while(resultSet.next()) {
                Religion religion = new Religion();
                religion.setId(resultSet.getInt("Id"));
                religion.setReligionName(resultSet.getString("ReligionName"));
                religions.add(religion);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return religions;
    }

}
