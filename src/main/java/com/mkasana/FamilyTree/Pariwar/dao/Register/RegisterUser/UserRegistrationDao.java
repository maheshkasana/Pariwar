package com.mkasana.FamilyTree.Pariwar.dao.Register.RegisterUser;

import com.mkasana.FamilyTree.Pariwar.model.userRegistrationAddressDetails;
import com.mkasana.FamilyTree.Pariwar.model.userRegistrationReligionDetails;
import com.mkasana.FamilyTree.Pariwar.model.userRegistrationRequest;

import java.sql.ResultSet;

public interface UserRegistrationDao {

    /**
     * this is for Registering basic details
     * @param user
     * @return
     */
    public void registerUserBasicDetails(final userRegistrationRequest user) throws Exception;

    public ResultSet getUserIdByUsername(final String username) throws Exception;

    public  void createOrUpdateUserAddress(userRegistrationAddressDetails address, int userId) throws Exception;

    public  void createOrUpdateUserReligiousDetails(final userRegistrationReligionDetails religious, final int userId) throws Exception;
}
