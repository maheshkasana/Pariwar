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
        SessionDetails session = null;
        try {
            session = validate.validateRequest(headers, true);
        } catch (Exception e) {}

        if(request.getRelation() > 0 && session == null) {
            throw new IllegalArgumentException("To add relation we must be logged In");
        }
        int creatorUser = 0;
        if(request.getRelation() > 0 && session != null) {
            creatorUser = session.getUserId();
        }
        /*
        headers.forEach((key, value) -> {
            System.out.printf("Parameter : %s, Value %s\n",key, value);
        });
        */

        int userId = userRegister.registerUserBasicDetails(request, creatorUser);
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
        SessionDetails session = null;
        try {
            session = validate.validateRequest(headers, true);
        } catch (Exception e) {

        }
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
        if(req.getRelation() > 0 && session == null) {
            throw new IllegalArgumentException("To add relation we must be logged In");
        }
        int creatorUser = 0;
        if(req.getRelation() > 0 && session != null) {
            creatorUser = session.getUserId();
        }
        //System.out.printf("Object Passed : %s\n",req.toString());
        userId = userRegister.registerUserBasicDetails(req, creatorUser);
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

        Path filepath = Paths.get("/Volumes/unix/SpringProjects/Pariwar/src/main/resources/static/images/userProfilePics/", "userProfilePic_"+userId+".jpg");
        file.transferTo(filepath);
        returnStatus.setStatusCode(userId);
        returnStatus.setErrorCode("Successfully registered user");
        return returnStatus;

    }


    @RequestMapping(value = "/profile/update/user", method = RequestMethod.POST, headers="Accept=application/json")
    private ReturnStatus updateProfileUser(@RequestBody userRegistrationRequest request,
                                      @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, true);
        int userId = session.getUserId();

        userRegister.updateUserBasicDetails(request, userId);
        ReturnStatus returnStatus = new ReturnStatus();
        returnStatus.setStatusCode(userId);
        returnStatus.setErrorCode("");

        return returnStatus;
    }

    @RequestMapping(value = "/profile/update/user/file", method = RequestMethod.POST)
    private ReturnStatus updateProfileUserFile(@RequestParam("body") String request,
                                          @RequestParam("Image") MultipartFile file, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, true);

        ReturnStatus returnStatus = new ReturnStatus();
        int userId = session.getUserId();
        ObjectMapper objectMapper = new ObjectMapper();
        userRegistrationRequest req = objectMapper.readValue(request, userRegistrationRequest.class);

        userRegister.updateUserBasicDetails(req, userId);

        if(0 >= userId) {
            System.out.println("Failed to register user");
            returnStatus.setStatusCode(-1);
            returnStatus.setErrorCode("Failed to register user, Please try after some time");
            return returnStatus;
        }

        Path filepath = Paths.get("/Volumes/unix/SpringProjects/Pariwar/src/main/resources/static/images/userProfilePics/", "userProfilePic_"+userId+".jpg");
        file.transferTo(filepath);
        returnStatus.setStatusCode(userId);
        returnStatus.setErrorCode("Successfully registered user");
        return returnStatus;

    }

}
