package com.mkasana.FamilyTree.Pariwar.Component.CommonAPIs.Impl;

import com.mkasana.FamilyTree.Pariwar.Builder.Register.AutoSuggest.UserAddressBuilder;
import com.mkasana.FamilyTree.Pariwar.Builder.Register.AutoSuggest.UserReligionBuilder;
import com.mkasana.FamilyTree.Pariwar.Builder.common.CommonAPIs;
import com.mkasana.FamilyTree.Pariwar.Component.CommonAPIs.CommonAPIsComponent;
import com.mkasana.FamilyTree.Pariwar.model.SessionDetails;
import com.mkasana.FamilyTree.Pariwar.model.UserFullDetails;
import com.mkasana.FamilyTree.Pariwar.model.userRegistrationAddressDetails;
import com.mkasana.FamilyTree.Pariwar.model.userRegistrationReligionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@Component
@Configurable
public class CommonAPIsComponentImpl implements CommonAPIsComponent {

    @Autowired
    CommonAPIs commonAPIsBuilder;
    @Autowired
    UserAddressBuilder userAddressBuilder;
    @Autowired
    UserReligionBuilder userReligionBuilder;

    public UserFullDetails getUserFullDetailsByToken(final String token) {

        SessionDetails sessionDetails = commonAPIsBuilder.getSessionDetailsByToken(token);
        if(sessionDetails == null) {
            System.out.println("Invalid Token Passed");
            return null;
        }

        int userId =  sessionDetails.getUserId();
        UserFullDetails userFullDetails = commonAPIsBuilder.getUserInfoDetailsByUserId(userId);
        if(userFullDetails == null) {
            System.out.println("Failed to retrive basic details of the User");
            return null;
        }

        if(userFullDetails.getUserAddressDetails().getIdAddress() > 0) {
            userRegistrationAddressDetails registrationAddressDetails = commonAPIsBuilder.getRegistrationAddressDetailsByAddressDetailsId(userFullDetails.getUserAddressDetails().getIdAddress());
            if(registrationAddressDetails != null) {
                userFullDetails.getUserAddressDetails().setLocality(registrationAddressDetails.getLocality());
                userFullDetails.getUserAddressDetails().setState(userAddressBuilder.getStateById(registrationAddressDetails.getState()));
                userFullDetails.getUserAddressDetails().setDistrict(userAddressBuilder.getDistrictById(registrationAddressDetails.getDistrict()));
                userFullDetails.getUserAddressDetails().setTehsil(userAddressBuilder.getTehsilById(registrationAddressDetails.getTehsil()));
                userFullDetails.getUserAddressDetails().setVillageTown(userAddressBuilder.getVillageTownById(registrationAddressDetails.getVillage()));
            }
        }

        if(userFullDetails.getUserReligiousDetails().getIdReligious() > 0) {
            userRegistrationReligionDetails registrationReligionDetails = commonAPIsBuilder.getRegistrationReligionDetailsByReligiousDetailId(userFullDetails.getUserReligiousDetails().getIdReligious());
            if(registrationReligionDetails != null) {
                userFullDetails.getUserReligiousDetails().setReligion(userReligionBuilder.getReligionById(registrationReligionDetails.getReligion()));
                userFullDetails.getUserReligiousDetails().setCaste(userReligionBuilder.getCasteById(registrationReligionDetails.getCaste()));
                userFullDetails.getUserReligiousDetails().setSubCaste(userReligionBuilder.getSubCasteById(registrationReligionDetails.getSubCaste()));
            }
        }
        return userFullDetails;
    }

}
