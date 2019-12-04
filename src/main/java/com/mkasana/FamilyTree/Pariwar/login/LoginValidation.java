package com.mkasana.FamilyTree.Pariwar.login;

import com.mkasana.FamilyTree.Pariwar.model.LoginRequestBody;
import com.mkasana.FamilyTree.Pariwar.model.LoginResponse;

public interface LoginValidation {

    public LoginResponse validateUser(LoginRequestBody loginRequestBody) throws Exception;
}
