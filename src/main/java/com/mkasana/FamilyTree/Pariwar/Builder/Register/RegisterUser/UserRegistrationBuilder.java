package com.mkasana.FamilyTree.Pariwar.Builder.Register.RegisterUser;

import com.mkasana.FamilyTree.Pariwar.dao.Register.RegisterUser.UserRegistrationDao;
import com.mkasana.FamilyTree.Pariwar.model.userRegistrationAddressDetails;
import com.mkasana.FamilyTree.Pariwar.model.userRegistrationReligionDetails;
import com.mkasana.FamilyTree.Pariwar.model.userRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;


@Configurable
@Component
public class UserRegistrationBuilder {

    @Autowired
    private UserRegistrationDao userRegistrationDao;

    /**
     * this is for Registering basic details
     * @param user
     * @return
     */
    public int registerUserBasicDetails(final userRegistrationRequest user) throws  Exception{

        try {
            userRegistrationDao.registerUserBasicDetails(user);
        } catch(Exception e) {
            System.out.println(e);
            throw  new Exception("Failed to Create Basic user details");
        }
        return 0;
    }

    public int updateUserBasicDetails(final userRegistrationRequest req , final int userId) throws  Exception
    {
        try {
            userRegistrationDao.updateUserBasicDetails(req, userId);
        } catch(Exception e) {
            System.out.println(e);
            throw  new Exception("Failed to Create Basic user details");
        }
        return 0;
    }

    public int UpdateUserLocalityAddress(final userRegistrationAddressDetails address , final int userId) throws  Exception
    {
        try {
            userRegistrationDao.UpdateUserLocalityAddress(address, userId);
        } catch(Exception e) {
            System.out.println(e);
            throw  new Exception("Failed to Create Basic user details");
        }
        return 0;
    }


    public int getUserIdByUsername(final String username) {
        try {
            ResultSet resultSet =  userRegistrationDao.getUserIdByUsername(username);
            if(resultSet.next()) {
                return resultSet.getInt("Id");
            }
        } catch(Exception e) {
            System.out.println(e);
            return 0;
        }
        return 0;
    }

    public int createOrUpdateUserAddress(final userRegistrationAddressDetails address, final int userId) throws Exception {
        try {
            userRegistrationDao.createOrUpdateUserAddress(address, userId);
        } catch(Exception e) {
            System.out.println(e);
            throw  new Exception("Failed to Create Basic user details");
        }
        return 0;
    }

    public int createOrUpdateUserReligiousDetails(final userRegistrationReligionDetails religious, final int userId) throws Exception {
        try {
            userRegistrationDao.createOrUpdateUserReligiousDetails(religious, userId);
        } catch(Exception e) {
            System.out.println(e);
            throw  new Exception("Failed to Create or Update Basic user Religious Details" + e);
        }
        return 0;
    }

}
