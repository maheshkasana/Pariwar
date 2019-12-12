package com.mkasana.FamilyTree.Pariwar.Builder.Register.AutoSuggest;

import com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.UserCountryDao;
import com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.UserReligionDao;
import com.mkasana.FamilyTree.Pariwar.model.Country;
import com.mkasana.FamilyTree.Pariwar.model.Religion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Configurable
@Component
public class UserAddressBuilder {

    @Autowired
    public UserCountryDao userCountryDao;



    /********************************************
     * All the below Builders are for Country *
     *******************************************/

    /**
     * This function is to return Country for Country Id
     * @param id
     * @return
     */
    public Country getCountryById(final int id) {
        final String function = "UserAddressBuilder:getCountryById";

        ResultSet resultSet;
        Country country = new Country();
        try {
            resultSet = userCountryDao.getUserCountryById(id);
            if(resultSet.next()) {
                country.setId(resultSet.getInt("Id"));
                country.setCountryName(resultSet.getString("CountryName"));
                country.setCountryCode(resultSet.getString("CountryCode"));
            }
            //Todo Convert the result set to the religion
        } catch(Exception e) {
            System.out.println(e);
        }
        return country;
    }


    public List<Country> getAllCountries() {
        final String function = "UserAddressBuilder:getAllCountries";

        ResultSet resultSet;
        List<Country> countries = new ArrayList<>();
        try {
            resultSet = userCountryDao.getUserAllCountries();
            while(resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getInt("Id"));
                country.setCountryName(resultSet.getString("CountryName"));
                country.setCountryCode(resultSet.getString("CountryCode"));
                countries.add(country);
            }
            //Todo Convert the result set to the religion
        } catch(Exception e) {
            System.out.println(e);
        }
        return countries;
    }
}
