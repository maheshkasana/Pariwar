package com.mkasana.FamilyTree.Pariwar.RestController;

import com.mkasana.FamilyTree.Pariwar.login.LoginValidation;
import com.mkasana.FamilyTree.Pariwar.model.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.mkasana.FamilyTree.Pariwar.model.LoginRequestBody;

/**
 * This Controller is for Login/Register
 */
@Service
@RestController
public class login {

    @Autowired(required =true)
    private LoginValidation loginValidation;

    @RequestMapping(value = "/login/validate", method = RequestMethod.POST, headers="Accept=application/json")
    private LoginResponse loginValidate(@RequestBody LoginRequestBody loginRequestBody, @RequestHeader HttpHeaders headers) {

        /*
        headers.forEach((key, value) -> {
           System.out.printf("Parameter : %s, Value %s\n",key, value);
        });

        System.out.printf("Body Passed : %s\n",loginRequestBody.toString());
        */

       return loginValidation.validateUser();
    }
}
