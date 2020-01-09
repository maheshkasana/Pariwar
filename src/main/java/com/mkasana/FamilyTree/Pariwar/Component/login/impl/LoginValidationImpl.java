package com.mkasana.FamilyTree.Pariwar.Component.login.impl;

import com.mkasana.FamilyTree.Pariwar.Builder.Register.AutoSuggest.UserAddressBuilder;
import com.mkasana.FamilyTree.Pariwar.Builder.common.CommonAPIs;
import com.mkasana.FamilyTree.Pariwar.dao.Impl.DatabaseConnectionImpl;
import com.mkasana.FamilyTree.Pariwar.Component.login.LoginValidation;
import com.mkasana.FamilyTree.Pariwar.model.LoginRequestBody;
import com.mkasana.FamilyTree.Pariwar.model.LoginResponse;
import com.mkasana.FamilyTree.Pariwar.model.userRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.UUID;

@Component
public class LoginValidationImpl implements LoginValidation {

    @Autowired
    public CommonAPIs commonAPIs;


    @Override
    public LoginResponse validateUser(LoginRequestBody loginRequestBody) throws Exception {

        //System.out.println("in LoginValidationImpl and Login Request body : " + loginRequestBody.toString());
        /*
        DatabaseConnectionImpl databaseConnection =  new DatabaseConnectionImpl();
        String SpResponse = databaseConnection.callStoredProcedure("ValidateLogin", loginRequestBody.toString());
        System.out.println("in LoginValidationImpl Response from SP "+SpResponse);
        */

        if(loginRequestBody.getUsername() == null || loginRequestBody.getPassword() == null || loginRequestBody.getUsername().length() < 0 || loginRequestBody.getPassword().length() < 0) {
            System.out.println("Invalid Username of Password Passed, Failed to validate");
            return new LoginResponse("","", 0,Boolean.FALSE, "Invalid Username or password passed");
        }

        final String username_i =  loginRequestBody.getUsername();
        final String password_i = new String(Base64.getDecoder().decode(loginRequestBody.getPassword()));

        userRegistrationRequest userBasicDetails = commonAPIs.getBasicUserDetailsByUsername(loginRequestBody.getUsername());
        //System.out.print("Request for the Customer  : "+loginRequestBody.getUsername());
        //System.out.print("Response for the Customer  : "+;
        final String usernameDB = userBasicDetails.getUsername();
        final String passwordDB = new String(Base64.getDecoder().decode(userBasicDetails.getPassword()));

        /*
        System.out.print("\nUsername In : " + username_i);
        System.out.print("\nPasssword In : " + new String(Base64.getDecoder().decode(password_i)));
        System.out.print("\nUsername DB : " + usernameDB);
        System.out.print("\nPassword DB : " + new String(Base64.getDecoder().decode(passwordDB)));
        */
        LoginResponse resp = new LoginResponse("","", 0,Boolean.FALSE, "");

        if(username_i.equals(usernameDB) && password_i.equals(passwordDB)) {
            System.out.println("Credentials Matched");
            String GUID = UUID.randomUUID().toString();

            boolean ret = commonAPIs.setSessionDetails(userBasicDetails.getUserId(), username_i, GUID);
            if(ret) {
                    resp.setMsg("Validation successful");
                    resp.setAuthKey(GUID);
                    resp.setUsername(username_i);
                    resp.setUserId(userBasicDetails.getUserId());
                    resp.setStatus(Boolean.TRUE);
            } else {
                resp.setMsg("Failed the validation workflow, Please try after some time");
            }
        } else {
            return resp;
        }
        return resp;
    }
}
