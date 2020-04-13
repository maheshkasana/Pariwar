package com.mkasana.FamilyTree.Pariwar.Component.Register.RegisterUser.Impl;

import com.mkasana.FamilyTree.Pariwar.Builder.Register.RegisterUser.UserRegistrationBuilder;
import com.mkasana.FamilyTree.Pariwar.Builder.common.CommonAPIs;
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

    @Autowired
    private CommonAPIs commonAPIsBuilder;

    /**
     * this is for Registering basic details
     * @param user
     * @return
     */
    public int registerUserBasicDetails(final userRegistrationRequest user, final  int creatorUser) {

        String Function = "UserRegistrationComponentImpl::registerUserBasicDetails";
        int userId = -1;
        try {
            userRegistrationBuilder.registerUserBasicDetails(user);
            userId = userRegistrationBuilder.getUserIdByUsername(user.getUsername());
            userRegistrationBuilder.createOrUpdateUserAddress(user.getAddress(), userId);
            userRegistrationBuilder.createOrUpdateUserReligiousDetails(user.getReligious(), userId);
            if(user.getRelation() > 0 && creatorUser > 0) {
                try {
                    final int relation = user.getRelation();
                    switch (relation) {
                        case 1:
                            commonAPIsBuilder.addParentToLoggedInUser(creatorUser,userId);
                            break;
                        case 2:
                            commonAPIsBuilder.addSpouseToUser(userId, creatorUser);
                            break;
                        case 3:
                            commonAPIsBuilder.addSiblingToUser(userId, creatorUser);
                            break;
                        case 4:
                            commonAPIsBuilder.addChildToLoggedInUser(creatorUser,userId);
                            break;
                        default:
                            //Do nothing
                            break;
                    }
                } catch(Exception e) {
                    //Do nothing
                }
            }
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
