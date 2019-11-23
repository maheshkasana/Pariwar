package com.mkasana.FamilyTree.Pariwar.login.impl;

import com.mkasana.FamilyTree.Pariwar.login.LoginValidation;
import com.mkasana.FamilyTree.Pariwar.model.LoginResponse;
import org.springframework.stereotype.Component;

@Component
public class LoginValidationImpl implements LoginValidation {

    @Override
    public LoginResponse validateUser() {
        LoginResponse login = new LoginResponse("MkasanaGurjar","asdasasd",101);
        return login;
    }
}
