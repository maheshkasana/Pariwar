package com.mkasana.FamilyTree.Pariwar.Component.Register.RegisterUser.Impl;

import com.mkasana.FamilyTree.Pariwar.Builder.Register.RegisterUser.UserRegistrationBuilder;
import com.mkasana.FamilyTree.Pariwar.Component.Register.RegisterUser.UserRegistrationComponent;
import com.mkasana.FamilyTree.Pariwar.model.userRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@Component
@Configurable
public class UserRegistrationComponentImpl  implements UserRegistrationComponent {

    @Autowired
    private UserRegistrationBuilder userRegistrationBuilder;

    /**
     * this is for Registering basic details
     * @param user
     * @return
     */
    public int registerUserBasicDetails(final userRegistrationRequest user) {

        String Function = "UserRegistrationComponentImpl::registerUserBasicDetails";
        int userId = -1;
        try {
            userRegistrationBuilder.registerUserBasicDetails(user);
            userId = userRegistrationBuilder.getUserIdByUsername(user.getUsername());
            userRegistrationBuilder.createOrUpdateUserAddress(user.getAddress(), userId);
            userRegistrationBuilder.createOrUpdateUserReligiousDetails(user.getReligious(), userId);
            return userId;
        } catch(Exception e) {
            System.out.println("Failed To create Create User");
            return -1;
        }
    }

    public int updateUserBasicDetails(final userRegistrationRequest req, final int userId) {
        String Function = "UserRegistrationComponentImpl::updateUserBasicDetails";
        try {
                userRegistrationBuilder.updateUserBasicDetails(req, userId);
                userRegistrationBuilder.UpdateUserLocalityAddress(req.getAddress(), userId);
                //userRegistrationBuilder.createOrUpdateUserReligiousDetails(req.getReligious(), userId);
                return userId;
        } catch(Exception e) {
            System.out.println("Failed To create Create User");
            return -1;
        }
    }

}
