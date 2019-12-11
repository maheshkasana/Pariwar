package com.mkasana.FamilyTree.Pariwar.Component.login.impl;

import com.mkasana.FamilyTree.Pariwar.dao.Impl.DatabaseConnectionImpl;
import com.mkasana.FamilyTree.Pariwar.Component.login.LoginValidation;
import com.mkasana.FamilyTree.Pariwar.model.LoginRequestBody;
import com.mkasana.FamilyTree.Pariwar.model.LoginResponse;
import org.springframework.stereotype.Component;

@Component
public class LoginValidationImpl implements LoginValidation {

    @Override
    public LoginResponse validateUser(LoginRequestBody loginRequestBody) throws Exception {
        System.out.println("in LoginValidationImpl and Login Request body : " + loginRequestBody.toString());

        DatabaseConnectionImpl databaseConnection =  new DatabaseConnectionImpl();
        String SpResponse = databaseConnection.callStoredProcedure("ValidateLogin", loginRequestBody.toString());
        System.out.println("in LoginValidationImpl Response from SP "+SpResponse);
        LoginResponse login = new LoginResponse("MkasanaGurjar","asdasasd",101, Boolean.TRUE);
        return login;
    }
}
