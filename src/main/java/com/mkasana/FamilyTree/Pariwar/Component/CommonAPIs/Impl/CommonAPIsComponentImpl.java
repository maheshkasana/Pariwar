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

import java.util.ArrayList;
import java.util.List;

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

        final int userId =  sessionDetails.getUserId();

        return getUserFullDetailsByUserId(userId);
    }

    /**
     * This is to return the list parents with full details.
     * @param token
     * @return
     */
    public List<UserFullDetails> getUserParentsDetailsByToken(final String token) {

        SessionDetails sessionDetails = commonAPIsBuilder.getSessionDetailsByToken(token);
        if(sessionDetails == null) {
            System.out.println("Invalid Token Passed");
            return null;
        }
        final int userId =  sessionDetails.getUserId();
        List<Integer> userParentList = commonAPIsBuilder.getUserParentIdList(userId);

        List<UserFullDetails> userParentFullDetails = new ArrayList<>();
        for(int id : userParentList)
            userParentFullDetails.add(getUserFullDetailsByUserId(id));

        return userParentFullDetails;
    }


    /**
     * This is to return the basic details of the use parents
     * @param token
     * @return
     */
    public List<UserFullDetails> getBasicUserParentsDetailsByToken(final String token) {

        SessionDetails sessionDetails = commonAPIsBuilder.getSessionDetailsByToken(token);
        if(sessionDetails == null) {
            System.out.println("Invalid Token Passed");
            return null;
        }
        final int userId =  sessionDetails.getUserId();
        List<Integer> userParentList = commonAPIsBuilder.getUserParentIdList(userId);

        List<UserFullDetails> userParentFullDetails = new ArrayList<>();
        for(int id : userParentList)
            userParentFullDetails.add(commonAPIsBuilder.getUserInfoDetailsByUserId(id));

        return userParentFullDetails;
    }


    /**
     * This is to return the list parents with full details.
     * @param token
     * @return
     */
    public List<UserFullDetails> getUserChildsDetailsByToken(final String token) {

        SessionDetails sessionDetails = commonAPIsBuilder.getSessionDetailsByToken(token);
        if(sessionDetails == null) {
            System.out.println("Invalid Token Passed");
            return null;
        }
        final int userId =  sessionDetails.getUserId();
        List<Integer> userChildsList = commonAPIsBuilder.getUserChildsIdList(userId);

        List<UserFullDetails> userParentFullDetails = new ArrayList<>();
        for(int id : userChildsList)
            userParentFullDetails.add(getUserFullDetailsByUserId(id));

        return userParentFullDetails;
    }


    /**
     * This is to return the basic details of the use parents
     * @param token
     * @return
     */
    public List<UserFullDetails> getBasicUserChildsDetailsByToken(final String token) {

        SessionDetails sessionDetails = commonAPIsBuilder.getSessionDetailsByToken(token);
        if(sessionDetails == null) {
            System.out.println("Invalid Token Passed");
            return null;
        }
        final int userId =  sessionDetails.getUserId();
        List<Integer> userChildsList = commonAPIsBuilder.getUserChildsIdList(userId);

        List<UserFullDetails> userParentFullDetails = new ArrayList<>();
        for(int id : userChildsList)
            userParentFullDetails.add(commonAPIsBuilder.getUserInfoDetailsByUserId(id));

        return userParentFullDetails;
    }



    /**
     * This is to return the list Siblings with full details.
     * @param token
     * @return
     */
    public List<UserFullDetails> getUserSiblingsDetailsByToken(final String token) {

        SessionDetails sessionDetails = commonAPIsBuilder.getSessionDetailsByToken(token);
        if(sessionDetails == null) {
            System.out.println("Invalid Token Passed");
            return null;
        }
        final int userId =  sessionDetails.getUserId();
        List<Integer> userParentList = commonAPIsBuilder.getUserParentIdList(userId);
        List<Integer> userSiblingsList = new ArrayList<>();

        for(int prntId : userParentList) {
            for (int id : commonAPIsBuilder.getUserChildsIdList(prntId)) {
                if (!userSiblingsList.contains(id))
                    userSiblingsList.add(id);
            }
        }

        List<UserFullDetails> userParentFullDetails = new ArrayList<>();
        for(int id : userSiblingsList)
            userParentFullDetails.add(getUserFullDetailsByUserId(id));

        return userParentFullDetails;
    }


    /**
     * This is to return the basic details of the use Siblings
     * @param token
     * @return
     */
    public List<UserFullDetails> getBasicUserSiblingsDetailsByToken(final String token) {

        SessionDetails sessionDetails = commonAPIsBuilder.getSessionDetailsByToken(token);
        if(sessionDetails == null) {
            System.out.println("Invalid Token Passed");
            return null;
        }
        final int userId =  sessionDetails.getUserId();
        final List<Integer> userParentList = commonAPIsBuilder.getUserParentIdList(userId);
        List<Integer> userSiblingsList = new ArrayList<>();

        for(int prntId : userParentList) {
            for (int id : commonAPIsBuilder.getUserChildsIdList(prntId)) {
                if (!userSiblingsList.contains(id))
                    userSiblingsList.add(id);
            }
        }

        List<UserFullDetails> userParentFullDetails = new ArrayList<>();
        for(int id : userSiblingsList)
            userParentFullDetails.add(commonAPIsBuilder.getUserInfoDetailsByUserId(id));

        return userParentFullDetails;
    }



    private  UserFullDetails getUserFullDetailsByUserId(final int userId) {
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
