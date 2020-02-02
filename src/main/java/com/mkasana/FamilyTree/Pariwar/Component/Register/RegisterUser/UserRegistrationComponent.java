package com.mkasana.FamilyTree.Pariwar.Component.Register.RegisterUser;

import com.mkasana.FamilyTree.Pariwar.model.userRegistrationRequest;

public interface UserRegistrationComponent {

    /**
     * this is for Registering basic details
     * @param user
     * @return
     */
    public int registerUserBasicDetails(final userRegistrationRequest user);

    public int updateUserBasicDetails(final userRegistrationRequest user, final int userId);
}
