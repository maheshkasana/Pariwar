package com.mkasana.FamilyTree.Pariwar.RestControllers.Register.RegisterUser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkasana.FamilyTree.Pariwar.Component.Register.RegisterUser.UserRegistrationComponent;
import com.mkasana.FamilyTree.Pariwar.Component.Validations.ValidationFunctions;
import com.mkasana.FamilyTree.Pariwar.Component.login.LoginValidation;
import com.mkasana.FamilyTree.Pariwar.model.ReturnStatus;
import com.mkasana.FamilyTree.Pariwar.model.SessionDetails;
import com.mkasana.FamilyTree.Pariwar.model.userRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This Controller is for Register
 */
@Service
@RestController
public class RegisterUser {

    @Autowired(required =true)
    private LoginValidation loginValidation;

    @Autowired(required = true)
    private UserRegistrationComponent userRegister;

    @Autowired
    private ValidationFunctions validate;

    @RequestMapping(value = "/register/user", method = RequestMethod.POST, headers="Accept=application/json")
    private ReturnStatus registerUser(@RequestBody userRegistrationRequest request,
                              @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, true);
        /*
        headers.forEach((key, value) -> {
            System.out.printf("Parameter : %s, Value %s\n",key, value);
        });
        */

        int userId = userRegister.registerUserBasicDetails(request);
        ReturnStatus returnStatus = new ReturnStatus();
        returnStatus.setStatusCode(userId);
        returnStatus.setErrorCode("");
        /*
        System.out.printf("File Passed : %s\n",file);
        System.out.printf("File Name : %s\n",file.getName());
        System.out.printf("File Origional Name : %s\n",file.getOriginalFilename());
        System.out.printf("File getContentType  : %s\n",file.getContentType());
        System.out.printf("File isEmpty  : %s\n",file.isEmpty());
        System.out.printf("File getSize  : %s\n",file.getSize());
        System.out.printf("File getBytes  : %s\n",file.getBytes());
        */
        /*
        File compressedImageFile = new File("1.jpeg");
        System.out.printf("File Content  : "+ file.getInputStream());
        file.transferTo(compressedImageFile);
        System.out.printf("File AbsolutePath  :" + compressedImageFile.getAbsolutePath());
        //System.out.printf("File Content  : "+ file.getInputStream());
        //return loginValidation.validateUser(loginRequestBody);
        */
        return returnStatus;
    }

    @RequestMapping(value = "/register/user/file", method = RequestMethod.POST)
    private ReturnStatus registerUserFile(@RequestParam("body") String request,
                                          @RequestParam("Image") MultipartFile file, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, true);
        /*
        headers.forEach((key, value) -> {
            System.out.printf("Parameter : %s, Value %s\n",key, value);
        });

        System.out.printf("Body Passed : %s\n",request.toString());
        */

        //int userId = userRegister.registerUserBasicDetails(request);
        //System.out.printf("Body Passed : %s\n",request.toString());

        ReturnStatus returnStatus = new ReturnStatus();
        int userId = -1;
        ObjectMapper objectMapper = new ObjectMapper();
        userRegistrationRequest req = objectMapper.readValue(request, userRegistrationRequest.class);
        //System.out.printf("Object Passed : %s\n",req.toString());
        userId = userRegister.registerUserBasicDetails(req);
        if(0 >= userId) {
            System.out.println("Failed to register user");
            returnStatus.setStatusCode(-1);
            returnStatus.setErrorCode("Failed to register user, Please try after some time");
            return returnStatus;
        }

        /*
        System.out.printf("File Passed : %s\n",file);
        System.out.printf("File Name : %s\n",file.getName());
        System.out.printf("File Origional Name : %s\n",file.getOriginalFilename());
        System.out.printf("File getContentType  : %s\n",file.getContentType());
        System.out.printf("File isEmpty  : %s\n",file.isEmpty());
        System.out.printf("File getSize  : %s\n",file.getSize());
        System.out.printf("File getBytes  : %s\n",file.getBytes());
        */
        /*
        File compressedImageFile = new File("1.jpeg");
        System.out.printf("File Content  : "+ file.getInputStream());
        file.transferTo(compressedImageFile);
        System.out.printf("File AbsolutePath  :" + compressedImageFile.getAbsolutePath());
        //System.out.printf("File Content  : "+ file.getInputStream());
        //return loginValidation.validateUser(loginRequestBody);
        */

        //Image Location ../../../userProfileImages/ $(Image Name)
        //Below Use the id ofuser to save the name if file

        Path filepath = Paths.get("/Volumes/unix/SpringProjects/Pariwar/userProfileImages", "userProfilePic_"+userId+".jpg");
        file.transferTo(filepath);
        returnStatus.setStatusCode(userId);
        returnStatus.setErrorCode("Successfully registered user");
        return returnStatus;

    }

}
