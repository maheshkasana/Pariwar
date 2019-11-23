package com.mkasana.FamilyTree.Pariwar.RestController;

import com.mkasana.FamilyTree.Pariwar.login.LoginValidation;
import com.mkasana.FamilyTree.Pariwar.model.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This Controller is for Login/Register
 */
@Service
@RestController
public class login {

    @Autowired(required =true)
    private LoginValidation loginValidation;

    @RequestMapping("/login/validate")
    private LoginResponse loginValidate() {
       return loginValidation.validateUser();
    }
}
