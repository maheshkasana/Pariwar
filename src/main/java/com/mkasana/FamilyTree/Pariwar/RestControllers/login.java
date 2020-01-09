package com.mkasana.FamilyTree.Pariwar.RestControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkasana.FamilyTree.Pariwar.Component.login.LoginValidation;
import com.mkasana.FamilyTree.Pariwar.model.LoginResponse;
import com.mkasana.FamilyTree.Pariwar.model.userRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import com.mkasana.FamilyTree.Pariwar.model.LoginRequestBody;

import java.util.Map;

/**
 * This Controller is for Login/Register
 */
@Service
@RestController
public class login {

    @Autowired(required =true)
    private LoginValidation loginValidation;

    @RequestMapping(value = "/login/validate", method = RequestMethod.POST, headers="Accept=application/json")
    private LoginResponse loginValidate(@RequestBody LoginRequestBody loginRequestBody, @RequestHeader HttpHeaders headers) throws Exception {

    /*
        Boolean isCookiesPassed = false;

        headers.forEach((key, value) -> {
           if(key.equals("cookie")) {
               ObjectMapper objectMapper = new ObjectMapper();
               LoginResponse cookies = objectMapper.readValue(value, LoginResponse.class);
           }
        });

        System.out.printf("Body Passed : %s\n",loginRequestBody.toString());
*/

       return loginValidation.validateUser(loginRequestBody);
    }
}
